package fr.afcepf.al28.spring;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class A {
	//Dépendance...
		private B b;
		//Injection de dépendance par Spring
		@Autowired
		public void setMachin(B b){
			this.b= b;
		}
		public String test() {
			return b.hello();
		}
}
