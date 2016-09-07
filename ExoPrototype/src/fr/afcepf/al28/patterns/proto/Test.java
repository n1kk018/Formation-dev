package fr.afcepf.al28.patterns.proto;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		StormTrooper st  = new StormTrooper();
		List<Soldier> army  = new ArrayList<Soldier>();
		
		for (int i = 0; i < 100; i++) {
			try {
				army.add(st.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Soldier soldier : army) {
			System.out.println(soldier.toString());
		}

	}

}
