
import fr.afcepf.atod.vin.data.api.IDaoGestionVin;
import fr.afcepf.atod.vin.data.exception.ExceptionsVin;
import fr.afcepf.atod.vin.entity.Product;
import fr.afcepf.atod.vin.entity.ProductAccessories;
import fr.afcepf.atod.vin.entity.ProductType;
import fr.afcepf.atod.vin.entity.ProductVarietal;
import fr.afcepf.atod.vin.entity.ProductWine;
import fr.afcepf.atod.vin.entity.Region;
import fr.afcepf.atod.vin.entity.Supplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ronan
 */
public class TestDataGestionVin {

    private static Logger log = Logger.getLogger(TestDataGestionVin.class);
    private static Map<String,ProductVarietal> varietals = new HashMap<String,ProductVarietal>();
    private static Map<String,ProductType> types = new HashMap<String,ProductType>();
    private static Map<String,Region> regions = new HashMap<String,Region>();
    private static java.util.List<ProductWine> list = new ArrayList<ProductWine>();

    public static void main(String[] args) {
        log.info("\t ### debut du test ###");

        BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springDataGestionVin.xml");
        IDaoGestionVin daoVin = (IDaoGestionVin) bf.getBean(IDaoGestionVin.class);

        Product productRand = new Product(null, "pre", 500.0, "un produit");

        Product productAccessorie = new ProductAccessories(null, "un mug",
                25.0, "un beau mug", new Date());

        Supplier supplier1 = new Supplier(null, "Aux bon vins de Bourgogne",
                "05 85 74 85 69",
                "vinsbourgogne@gmail.com", new Date());
        Supplier supplier2 = new Supplier(null, "Aux bon vins de Bordeaux",
                "04 85 74 85 69",
                "vinsbordeaux@gmail.com", new Date());
        Supplier supplier3 = new Supplier(null, "Aux bon vins de l'Aude",
                "07 85 74 85 69",
                "vinsaude@gmail.com", new Date());
        try {
	        //Les Set sont particulièrement adaptés pour manipuler une grande
	        //quantité de données. Cependant, les performances de ceux-ci peuvent
	        //être amoindries en insertion. Généralement, on opte pour un HashSet,
	        //car il est plus performant en temps d'accès 
	        Set<Supplier> suppliersRand = new HashSet<Supplier>();
	        suppliersRand.add(supplier1);
	        suppliersRand.add(supplier2);
	        productRand.setStockSuppliers(suppliersRand);
	        daoVin.addProduct(productRand);
	        Set<Supplier> suppliersAccessorie= new HashSet<Supplier>();
	        suppliersAccessorie.add(supplier1);
	        productAccessorie.setStockSuppliers(suppliersAccessorie);
	        daoVin.addProduct(productAccessorie);
	        for(int i=1;i<7;i++){
	        	list = parseSampleXml("wines"+i+".xml");
		        Integer cpt = 0;
		        for (ProductWine productWine: list) {
		        	Set<Supplier> supplierWine = new HashSet<>();
		        	supplierWine.add(supplier1);
		        	if(cpt%2==0) {
		        		supplierWine.add(supplier2);
		        	}else if(cpt%3==0) {
		        		supplierWine.add(supplier3);
		        	}
		        	productWine.setStockSuppliers(supplierWine);
		        	daoVin.addProduct(productWine);
		        	cpt++;
				}
	        }
        } catch (ExceptionsVin ex) {
            java.util.logging.Logger.getLogger(TestDataGestionVin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        log.info("\t ### Fin du test ###");
    }
    
    public static java.util.List<ProductWine> parseSampleXml(String fileName) throws ExceptionsVin
    {
    	java.util.List<ProductWine> wineList = new ArrayList<ProductWine>();
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 dbf.setNamespaceAware(true);
		 Document xml=null;
		try {
			xml = dbf.newDocumentBuilder()
							 .parse(Thread.currentThread()
							 .getContextClassLoader()
							 .getResourceAsStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		NodeList subNodes = xml.getElementsByTagName("Product");
		for(int i = 0; i<subNodes.getLength();i++){
			Node node = subNodes.item(i);
			Element tag = (Element)node;
			wineList.add(setWine(tag));
		}
		return wineList;
    }
    
    private static ProductWine setWine(Node itemNode) {
    	ProductWine p = new ProductWine();
		NodeList wineInfos = itemNode.getChildNodes();
		p.setName(extractNameFromSubNodeList(wineInfos));
		for(int i = 0; i<wineInfos.getLength();i++){
			if(wineInfos.item(i).getNodeName().equals("Vintage")){
				try{
					p.setVintage(Integer.parseInt(wineInfos.item(i).getTextContent()));
				}catch(NumberFormatException e) {
					p.setVintage(null);
				}
			}
			if(wineInfos.item(i).getNodeName().equals("PriceRetail")){
				p.setPrice(Double.valueOf(wineInfos.item(i).getTextContent()));
			}
			if(wineInfos.item(i).getNodeName().equals("Appellation")){
				p.setAppellation(extractNameFromSubNodeList(wineInfos.item(i).getChildNodes()));	
				p.setRegion(getWineRegion(wineInfos.item(i)));
			}
			if(wineInfos.item(i).getNodeName().equals("Varietal")){
				
				p.setProductVarietal(getWineVarietal(wineInfos.item(i)));
				p.setProductType(getWineType(wineInfos.item(i)));
				
			}
			if(wineInfos.item(i).getNodeName().equals("ProductAttributes")){
				p.setDescription(getWineDescription(wineInfos.item(i)));
			}
		}
    	return p;
    }
    
    private static ProductVarietal getWineVarietal(Node varietalNode){
    	String varietal = extractNameFromSubNodeList(varietalNode.getChildNodes());
		ProductVarietal oVarietal=null;
		if(varietals.containsKey(varietal)==false) {
			oVarietal = new ProductVarietal(null,varietal);
			varietals.put(varietal, oVarietal);
		} else {
			oVarietal = (ProductVarietal)varietals.get(varietal);
		}
    	return oVarietal;
    }
    
    private static Region getWineRegion(Node appellationNode){
    	Region oRegion = new Region();
    	for(int j = 0; j<appellationNode.getChildNodes().getLength();j++){
			if(appellationNode.getChildNodes().item(j).getNodeName().equals("Region")){
				String region = extractNameFromSubNodeList(appellationNode.getChildNodes().item(j).getChildNodes());
				if(regions.containsKey(region)==false) {
					oRegion = new Region(null,region,null);
					regions.put(region, oRegion);
				} else {
					oRegion = (Region)regions.get(region);
				}
			}
    	}
    	return oRegion;
    }
    
    private static ProductType getWineType(Node varietal){
    	ProductType oType=null;
    	for(int j = 0; j<varietal.getChildNodes().getLength();j++){
			if(varietal.getChildNodes().item(j).getNodeName().equals("WineType")){
				String type = extractNameFromSubNodeList(varietal.getChildNodes().item(j).getChildNodes());
				if(types.containsKey(type)==false) {
					oType = new ProductType(null,type);
					types.put(type, oType);
				} else {
					oType = (ProductType)types.get(type);
				}
			}
		}
    	return oType;
    }
    
    private static String getWineDescription(Node attributes){
    	String description = "";
		for(int j = 0; j<attributes.getChildNodes().getLength();j++){
			if(attributes.getChildNodes().item(j).getNodeName().equals("ProductAttribute")){
				if(j>0){
					description=description+"|";
				}
				description=description+extractNameFromSubNodeList(attributes.getChildNodes().item(j).getChildNodes());
			}
		}
		return description;
		
    }
    
    private static String extractNameFromSubNodeList(NodeList subNodes)
    {
    	String name = null;
    	for(int i = 0; i<subNodes.getLength();i++){
    		if(subNodes.item(i).getNodeName().equals("Name")){
    			name = subNodes.item(i).getTextContent();
    		}
    	}
    	return name;
    }
    
}
