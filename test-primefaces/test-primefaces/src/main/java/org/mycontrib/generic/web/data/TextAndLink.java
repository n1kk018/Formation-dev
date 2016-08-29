package org.mycontrib.generic.web.data;

public class TextAndLink {
		private String texte;
		private String link;
		
		public TextAndLink(String texte, String link) {
			super();
			this.texte = texte;
			this.link = link;
		}
		
		
		public TextAndLink() {
			super();
		}



		public String getTexte() {
			return texte;
		}
		public void setTexte(String texte) {
			this.texte = texte;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		
		
}
