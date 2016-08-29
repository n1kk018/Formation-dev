package fr.afcepf.al28.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf._2016.product.ProductType;
import fr.afcepf.al28.data.Client;

public class JaxbXmlParser {
	private static Logger logger = LoggerFactory.getLogger(JaxbXmlParser.class);

	public static void main(String[] args) {
		try {
			JAXBElement<ProductType> product = null;
			JAXBContext jctx = JAXBContext.newInstance("fr.afcepf._2016.product");
			Unmarshaller um = jctx.createUnmarshaller();
			Marshaller m = jctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("avec_namespaces/product.xml");
			product = (JAXBElement<ProductType>) um.unmarshal(is);
			ProductType prod = product.getValue();
			logger.info("prix : "+prod.getPrice());
			logger.info("numero : "+prod.getNum());
			logger.info("description : "+prod.getDescription());
			
			fr.afcepf._2016.product.ObjectFactory objectFactory = new fr.afcepf._2016.product.ObjectFactory();
			ProductType prod2 = objectFactory.createProductType();
			prod2.setNum(BigInteger.valueOf(55));
			prod2.setPrice(BigDecimal.valueOf(8.56));
			prod2.setDescription("Cigarette box");
			JAXBElement<ProductType> product2 = objectFactory.createProduct(prod2);
			try {
				m.marshal(product2, new FileOutputStream("product2.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JAXBContext jctx2 = JAXBContext.newInstance(Client.class);
			Client cli = new Client("toto", 39);
			Marshaller m2 = jctx2.createMarshaller();
			m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			try {
				m2.marshal(cli,new FileOutputStream("client.xml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
