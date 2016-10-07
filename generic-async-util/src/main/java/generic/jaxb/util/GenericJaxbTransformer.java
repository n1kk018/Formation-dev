package generic.jaxb.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class GenericJaxbTransformer{
		
	private JAXBContext context ;
	private Unmarshaller um ;
	private Marshaller m ;
	
	public GenericJaxbTransformer(Class javaClass){
		try {
			context = JAXBContext.newInstance(javaClass);
			um = context.createUnmarshaller();
			m = context.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	public Object xmlStringToJava(String xmlString){
		Object javaObj =null;
		try {
			javaObj =   um.unmarshal(new StreamSource(new StringReader(xmlString)));
			//System.out.println("xmlStringToJava:" + javaObj.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return javaObj;
	}
	
	public String javaToXmlString(Object javaObj){
		String xmlString =null;
		try {
			StringWriter sw = new StringWriter();
			m.marshal(javaObj,sw);
			xmlString=sw.toString();
			//System.out.println("javaToXmlString:"+xmlString);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlString;
	}
}
