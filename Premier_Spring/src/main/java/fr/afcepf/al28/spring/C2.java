package fr.afcepf.al28.spring;

import org.springframework.stereotype.Service;

@Service
public class C2 extends C {
	@Override
	public String helloSpring() {
		return "Coucou Spring";
	}
}
