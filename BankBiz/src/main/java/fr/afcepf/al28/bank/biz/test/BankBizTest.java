package fr.afcepf.al28.bank.biz.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.bank.biz.IBizClient;
import fr.afcepf.al28.bank.entity.Client;

public class BankBizTest {
	private static Logger logger = LoggerFactory.getLogger(BankBizTest.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");

	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springBiz.xml");
		IBizClient bizC =  bf.getBean(IBizClient.class);
		Client c = new Client(null,"Sto","nikko","test","nicolastorero@gmail.com","test");
		if(bizC.Login(c)!=null) {
			logger.info("Loggé");
		}else{
			logger.info("Pas Loggé");
		}
		
	}

}
