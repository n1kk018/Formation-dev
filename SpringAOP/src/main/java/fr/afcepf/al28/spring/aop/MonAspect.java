package fr.afcepf.al28.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;


@Aspect
public class MonAspect {
	private  Logger logger = LoggerFactory.getLogger(MonAspect.class);
	private  Marker fatal = MarkerFactory.getMarker("FATAL");
	@Before(
	"execution(* fr..UneClasse.uneMethode(..))")
	public void testBeforeMethode() {
		logger.info("avant la méthode");
	}
	@After(
	"execution(* fr..UneClasse.uneMethode(..))")
	public void testAfterMethode() {
		logger.info("aprés la méthode");
	}
	@Before(
	"execution(* fr..UneClasse.*(..))")
	public void testBeforeAllMethode(JoinPoint jp) {
		logger.info("avant.."+jp.getSignature().getName());
	}
	@AfterThrowing(pointcut="execution(* fr..UneClasse.*(..))",throwing="e") 
	public void apresException(JoinPoint jp,Exception e) {
		logger.error(fatal,"Exception sur "+jp.getSignature().getName()+"\t"+e.getMessage());
	}
	@Around("execution(* fr..UneClasse.uneAutreMethode(..))")
	public Object aroundUneAutreMethode(ProceedingJoinPoint jp) throws Throwable {
		Object o  = 418522;
		jp.getArgs()[0] = (Integer.parseInt(jp.getArgs()[0].toString())+1)+"";
		o = jp.proceed(jp.getArgs());
		return o;
	}
}
