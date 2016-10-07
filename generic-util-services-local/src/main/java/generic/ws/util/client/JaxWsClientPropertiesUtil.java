package generic.ws.util.client;

import generic.ws.util.client.wss.SimpleWssHandlerResolverSettings;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.xml.ws.Service;

/**
 * 
 * @author Didier DEFRANCE
 *
 * Classe utilitaire pour paramétrer un appel de web service SOAP
 * version sans cxf ne nécessitant que le jdk >= 1.6 .
 */

public class JaxWsClientPropertiesUtil<S extends Service> {
	private String propertiesFileName;
	Properties props = new Properties(); //java.util
	private Class<S> soapServiceClass;

	public JaxWsClientPropertiesUtil() {
		super();
		//initsoapServiceClass();
	}

	public JaxWsClientPropertiesUtil(String propertiesFileName,Class<S> soapServiceClass) {
		super();
		this.propertiesFileName = propertiesFileName;
		//initsoapServiceClass();//si avec un arg de moins au constructeur
		this.soapServiceClass=soapServiceClass;
		initProperties();
	}
	
	public S getSoapService(){
		S soapService = null;
		try{
		URL wsdlURL= new URL(props.getProperty("wsdl.url"));
		soapService = soapServiceClass.getDeclaredConstructor(URL.class).newInstance(wsdlURL);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return soapService;
	}
	
	public void setBasicHttpAuthFromProperties(Object wsProxy){
		WsBindingProviderUtil.setBasicHttpAuth(wsProxy,props.getProperty("username"), props.getProperty("password"));
	}
	
	public void setWssAuthFromProperties(Service soapService){
		SimpleWssHandlerResolverSettings.setWssUsernameTokenHandlerResolver(soapService,
	            props.getProperty("username"),props.getProperty("password"));
	}
	
	/*public void setWssAuthFromProperties(Object wsProxy){
		Service soapService=null;
		Client clientSoap = (Client) wsProxy;
		//accéder au service en partant du endpoint/proxy ???
		SimpleWssHandlerResolverSettings.setWssUsernameTokenHandlerResolver(soapService,
	            props.getProperty("username"),props.getProperty("password"));
	}*/
	
	public void setEndpointUrlFromProperties(Object wsProxy){
		WsBindingProviderUtil.setSoapEndpointUrl(wsProxy, props.getProperty("soap.url"));
	}
	
	private void initsoapServiceClass(){
		//...via introspection
	}
	
	private void initProperties(){
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public String getPropertiesFileName() {
		return propertiesFileName;
	}

	public void setPropertiesFileName(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
		initProperties();
	}

	public Class<S> getSoapServiceClass() {
		return soapServiceClass;
	}

	public void setSoapServiceClass(Class<S> soapServiceClass) {
		this.soapServiceClass = soapServiceClass;
	}
	
	
	
	

}
