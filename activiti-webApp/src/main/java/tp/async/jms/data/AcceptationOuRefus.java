package tp.async.jms.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class AcceptationOuRefus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String refDemande; //corrData (id/ref de la chose à accepter ou refuser)
	private boolean acceptation;//true si accepté , false si refusé
	private String texte;//formulation/argumentation raison acceptation ou refus
	
	public AcceptationOuRefus(String refDemande, boolean acceptation,
			String texte) {
		super();
		this.refDemande = refDemande;
		this.acceptation = acceptation;
		this.texte = texte;
	}

	public AcceptationOuRefus() {
		super();
	}
	
	@Override
	public String toString() {
		return "AcceptationOuRefus [refDemande=" + refDemande
				+ ", acceptation=" + acceptation + ", texte=" + texte + "]";
	}
	public String getRefDemande() {
		return refDemande;
	}
	public void setRefDemande(String refDemande) {
		this.refDemande = refDemande;
	}
	public boolean isAcceptation() {
		return acceptation;
	}
	public void setAcceptation(boolean acceptation) {
		this.acceptation = acceptation;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
}
