package fr.afcepf.al28.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomXmlParser {
	
	private static Logger logger = LoggerFactory.getLogger(DomXmlParser.class);
	private static final String JAXP_SCHEMA_LANGUAGE =
			"http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private static final String  JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	public static void main(String[] args){
		try { 
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			 dbf.setNamespaceAware(true);
			 dbf.setValidating(true);
			 dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			 dbf.setAttribute(JAXP_SCHEMA_SOURCE, Thread.currentThread()
					 								.getContextClassLoader()
					 								.getResourceAsStream("avec_namespaces/product.xsd"));
			 Document xml =	dbf.newDocumentBuilder()
							 .parse(Thread.currentThread()
							 .getContextClassLoader()
							 .getResourceAsStream("avec_namespaces/product.xml"));
			Element root = xml.getDocumentElement();
			logger.info("num="+root.getAttribute("num"));
			//V1: parcours en boucle avec "if"
			NodeList subNodes = root.getChildNodes();
			for(int i = 0; i<subNodes.getLength();i++){
				Node node = subNodes.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE){
					Element tag = (Element)node;
					logger.info(tag.getNamespaceURI()+":"+tag.getLocalName()+" : "+tag.getTextContent());
				}
			}
			//V2: accés direct via getElementByName()
			Element DescriptionSubNode = (Element)xml.getElementsByTagNameNS("http://www.afcepf.fr/2016/product", "description").item(0); //xml.getElementsByTagName("description").item(0);
			Element PriceSubNode = (Element)xml.getElementsByTagNameNS("http://www.afcepf.fr/2016/product", "price").item(0); //xml.getElementsByTagName("price").item(0);
			logger.info("V2 --> "+DescriptionSubNode.getNodeName()+" : "+DescriptionSubNode.getTextContent());
			logger.info("V2 --> "+PriceSubNode.getNodeName()+" : "+PriceSubNode.getTextContent());
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
