package fr.afcepf.al28.springtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.spring.A;


public class TestSpring {
	private static Logger logger = LoggerFactory.getLogger(TestSpring.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");

	public static void main(String[] args) {
		logger.info("demarrage");
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:spring.xml");
		//A a = (A) bf.getBean("beanA");
		A a = bf.getBean(A.class);
		logger.info(a.test());
		logger.info("fin du test");
	}

}
