package fr.afcepf.al28.spring.aop.test;

import java.beans.beancontext.BeanContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.spring.aop.MonAspect;
import fr.afcepf.al28.spring.aop.UneClasse;

public class TestAop {
	private static Logger logger = LoggerFactory.getLogger(TestAop.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");
	
	public static void main(String[] args) {
		try {
			logger.info("dans classe de test");
			BeanFactory bf = new ClassPathXmlApplicationContext("classpath:spring.xml");
			UneClasse uneClasse = bf.getBean(UneClasse.class);
			String s = uneClasse.uneMethode(6);
			logger.info("s="+s);
			int i = uneClasse.uneAutreMethode("6");
			logger.info("i="+i);
			uneClasse.methode();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			logger.error(fatal,e.getMessage());
		}
	}
}
