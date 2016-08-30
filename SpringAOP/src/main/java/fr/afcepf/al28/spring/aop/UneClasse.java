package fr.afcepf.al28.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class UneClasse {
	public void methode() throws ArithmeticException {
		int i= 1/0;
	}
	
	public String uneMethode(int i) {
		String s ="";
		s=String.valueOf(i);
		return s;
	}
	
	public int uneAutreMethode(String s) {
		int i =0 ;
		i=Integer.parseInt(s);
		System.out.println("Coucou d'ici");
		return i;
	}
}
