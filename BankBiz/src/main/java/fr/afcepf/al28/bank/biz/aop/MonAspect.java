package fr.afcepf.al28.bank.biz.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.bank.entity.Client;
import fr.afcepf.al28.bank.entity.Utilisateur;


@Aspect
public class MonAspect {
	private  Logger logger = LoggerFactory.getLogger(MonAspect.class);
	private  Marker fatal = MarkerFactory.getMarker("FATAL");
	
	@Around("execution(* fr..BizClient.Login(..))")
	public Object aroundLoginClient(ProceedingJoinPoint jp) throws Throwable {
		logger.info("debut aspect");
		Client c  = (Client)jp.proceed(jp.getArgs());
		if(c!=null && c.getIsFirstConnect()==true) {
			logger.info("redirection");
			throw new Exception("redirection");
		}
		logger.info("pas de redirection");
		return c;
	}
}
