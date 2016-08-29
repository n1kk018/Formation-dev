package fr.afcepf.al28.ex;

public class Rectangle { 
	private int x1; 
	private int y1;            /* private int largeur; // v1 */ 
	private int x2; // v2 /* private int hauteur; // v1 */ 
	private int y2; // V2
	public int getX1() {return x1;} 
	public void setX1(int x1) {  this.x1 = x1;}
	public int getY1() {return y1; } 
	public void setY1(int y1) { this.y1 = y1;} 
	public int getLargeur() { /* return largeur; // V1 */      
		return (x2-x1); // V2  
	} 
	public void setLargeur(int largeur) { /* this.largeur = largeur; // V1 */ this.x2 = this.x1 + largeur; // V2 
	} 
	public int getHauteur() { /* return hauteur; //v1 */     
		return (y2-y1); // V2 
	} 
	public void setHauteur(int hauteur) { /* this.hauteur = hauteur; // V1 */ this.y2 = this.y1 + hauteur;  // V2
	}
}

