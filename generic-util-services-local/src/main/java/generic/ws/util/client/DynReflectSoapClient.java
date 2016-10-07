package generic.ws.util.client;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.SOAPBinding;

/*
 * Appel dynamique d'une méthode sur un service soap
 * en se basant sur une introspection de l'interface java
 * et en utilisant l'api wsdl4j pour découvrir les QNAME du service et du port/endpoint
 */

public class DynReflectSoapClient {
	
	private Map<String,Object> mapUrlProxy = new HashMap<String,Object>();
	
	
	public Object getWsProxy(String wsUrl,Class sei){
		Object soapProxy = null;
		soapProxy = mapUrlProxy.get(wsUrl);
	    if(soapProxy==null){
	    	try{
				WSDLReader wSDLReader = WSDLFactory.newInstance().newWSDLReader();
				Definition wsdlDefinition = wSDLReader.readWSDL(wsUrl+"?wsdl");
				//on s'interesse ici au premier service (souvent le seul) du wsdl:
				javax.wsdl.Service serviceDefinition = (javax.wsdl.Service) wsdlDefinition.getServices().values().iterator().next();
				QName SERVICE_NAME = serviceDefinition.getQName();
				javax.wsdl.Port portDefinition = (javax.wsdl.Port) serviceDefinition.getPorts().values().iterator().next();
				QName PORT_NAME = new QName(wsdlDefinition.getTargetNamespace()  , portDefinition.getName());
				javax.xml.ws.Service service = javax.xml.ws.Service.create(SERVICE_NAME);		
				// Add a port to the Service , javax.xml.ws.soap.SOAPBinding
				// code a peaufiner si plusieurs ports ou si SOAP12
				service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,wsUrl);
				soapProxy =  service.getPort(PORT_NAME, sei);
				mapUrlProxy.put(wsUrl, soapProxy);
		      } catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return soapProxy;
	}
	
	public Object getWsProxy(String wsUrl,String serviceInterfaceName){
		Object soapProxy = null;
		 try {
			Class sei = Class.forName(serviceInterfaceName);
			soapProxy = getWsProxy( wsUrl,sei);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return soapProxy;
	}
	
	public Object dynSoapCall(String wsUrl,String serviceInterfaceName,String methodName,Object ... soapArgs){
		Object result=null;
			try {
				    Class sei = Class.forName(serviceInterfaceName);
				    Object soapProxy = getWsProxy( wsUrl,sei);
					Method[] methods = sei.getDeclaredMethods();
					Method m=null;
					for(Method me: methods){
						if(me.getName().equals(methodName)){
							m=me; break;
						}
					}
					result=m.invoke(soapProxy, soapArgs);
				} catch (Exception e) {
					e.printStackTrace();
				}
		return result;
	}

}
