package fr.afcepf.al28.uml.retro.test;

abstract public class Figure implements Dessinable {
    protected String couleur;
    protected String getCouleur ( ) { return couleur; }
    protected void setCouleur ( String c ) { couleur = c; }
}

