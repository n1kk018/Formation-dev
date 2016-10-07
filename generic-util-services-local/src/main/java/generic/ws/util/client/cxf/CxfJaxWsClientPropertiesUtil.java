package generic.ws.util.client.cxf;

import generic.ws.util.client.WsBindingProviderUtil;
import generic.ws.util.client.wss.SimpleWssHandlerResolverSettings;
import generic.ws.util.client.wss.cxf.CxfWSSUsernameTokenSecurityUtil;

import java.io.IOException;
import java.util.Properties;

import javax.xml.ws.Service;

/**
 * 
 * @author Didier DEFRANCE
 *
 * Classe utilitaire pour paramétrer un appel de web service SOAP
 * version simplifiée avec cxf mais nécessitant quelques libairies de cxf en plus du jdk >= 1.6 .
 */


public class CxfJaxWsClientPropertiesUtil {
	private String propertiesFileName;
	Properties props = new Properties(); //java.util
	

	public CxfJaxWsClientPropertiesUtil() {
		super();
	}

	public CxfJaxWsClientPropertiesUtil(String propertiesFileName) {
		super();
		this.propertiesFileName = propertiesFileName;
		initProperties();
	}
	
	
	
	public void setBasicHttpAuthFromProperties(Object wsProxy){
		WsBindingProviderUtil.setBasicHttpAuth(wsProxy,props.getProperty("username"), props.getProperty("password"));
	}
	
	public void setWssAuthFromProperties(Service soapService){
		SimpleWssHandlerResolverSettings.setWssUsernameTokenHandlerResolver(soapService,
	            props.getProperty("username"),props.getProperty("password"));
	}
	
	public void setWssAuthFromProperties(Object wsProxy){
		CxfWSSUsernameTokenSecurityUtil cxfWSSUsernameTokenSecurityUtil 
		= new CxfWSSUsernameTokenSecurityUtil(props.getProperty("username"),props.getProperty("password"));
		
		cxfWSSUsernameTokenSecurityUtil.setWssSecurityViaCxf(wsProxy);
	}
	
	public void setEndpointUrlFromProperties(Object wsProxy){
		WsBindingProviderUtil.setSoapEndpointUrl(wsProxy, props.getProperty("soap.url"));
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

}
