package com.formation.model;

public class InverseBean {
    public String execute(String input) {
         char[] tab = input.toCharArray();
         String retour="";
         for (int i = tab.length-1; i >= 0 ; i--) {
            retour += tab[i];
        }
        return retour;
    }
}
