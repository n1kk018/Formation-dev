package fr.afcepf.al28.fichier;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al28.tp.AvionV3;
import fr.afcepf.al28.tp.Bagage;
import fr.afcepf.al28.tp.ConsoleApp;
import fr.afcepf.al28.tp.Employe;
import fr.afcepf.al28.tp.Personne;

public class FicApp {
	
	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);

	public static void main(String[] args) {
		try {
			AvionV3 avion = new AvionV3();
			avion.addElement(new Personne("Alice",50f,50));
			avion.addElement(new Personne("Bob",50f,56));
			avion.addElement(new Personne());
			avion.addElement(new Employe("Michael",90.5f,82,2550d));
			avion.addElement(new Employe());
			avion.addElement(new Bagage(15.6f,"Valise-Michael",45));
			avion.addElement(new Bagage(20.8f,"Sac-Bob",70));
			avion.addElement(new Bagage(31.5f,"Valise-Alice",100));
			avion.setCouleur("rouge");
		
			OutputStream outFileStream = new FileOutputStream("avion.ser");
			ObjectOutputStream outObjStream = new ObjectOutputStream(outFileStream);
			outObjStream.writeObject(avion);
			outObjStream.close();outFileStream.close();
			AvionV3 avionBis = null;
			InputStream inFileStream = new FileInputStream("avion.ser");
			ObjectInputStream inObjStream = new ObjectInputStream(inFileStream);
			avionBis = (AvionV3)inObjStream.readObject();
			inObjStream.close();inFileStream.close();
			avionBis.afficher();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {	
//		InputStream fluxLecture = FicApp.class.getClassLoader().getResourceAsStream("regions.txt");
//		//regions.txt est recherché à la racine du CLASSPATH
//		BufferedReader fluxLignes = new BufferedReader(new InputStreamReader(fluxLecture));
////		String ligne;
////		while((ligne=fluxLignes.readLine())!=null) {
////			logger.info(ligne);
////		}
//		fluxLignes.lines()
//				  .filter((ligne)->!ligne.equals("..."))
//				  .map(String::toUpperCase)
//				  .forEach(logger::info);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}
}
