package fr.afcepf.al28.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al28.tp.Bagage;
import fr.afcepf.al28.tp.Personne;

import java.lang.reflect.Field;

public class ConsoleApp {

	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);
	
	public static void main(String[] args) {
		Personne p1 = new Personne("Alice",50f,50);
		logger.info(getPrimaryKeyOfObject(p1));
		
		Bagage b1 =new Bagage(15.6f,"Valise-Michael",45);
		afficherChoseQuelconque(b1);
		
	}
	
	
	public static void afficherChoseQuelconque(Object o) {
		try {
			Class<?> c = o.getClass();
			for(Field f : c.getDeclaredFields()) {
				f.setAccessible(true);//Pour tout de même accéder aux valeurs des champs privés avec la méthode 'get()'
				logger.info(f.getName()+ " : " +f.getType().getSimpleName() + " : "+f.get(o) + ((f.getAnnotation(MyId.class)!=null)?"\t(id/pk)":""));
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getPrimaryKeyOfObject(Object o) {
		String pkValue = null;
		try {
			Class<?> c = o.getClass();
			for(Field f : c.getDeclaredFields()) {
				if(f.getAnnotation(MyId.class)!=null) {
					f.setAccessible(true);
					pkValue=(String) f.get(o);
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pkValue;
	}

}
