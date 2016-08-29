package fr.afcepf.al28.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class B {
	//Dépendance...
	private C c;
	//Injection de dépendance par Spring
	@Autowired
	public void setUnTruc(C c){
		this.c = c;
	}
	public String hello() {
		return c.helloSpring();
	}
}
