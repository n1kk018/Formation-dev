package fr.afcepf.al28.livraison.exceptions;

/**
 * Classe pour les {@link Exception} de l'application.
 * @author stagiaire
 *
 */

public class QualitException extends Exception {

    /**
     * pour la sérialisation.
     */
    private static final long serialVersionUID = -4353648915364145799L;
    /**
     * code d'erreur de l'exception.
     */
    private QualitEnum codeErreur = QualitEnum.CA_MARCHE_PAS;

    /**
     *d default constructor.
     */
    public QualitException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param paramMessage le message.
     * @param paramCodeErreur le code d'erreur.
     */
    public QualitException(String paramMessage, QualitEnum paramCodeErreur) {
        super(paramMessage);
        codeErreur = paramCodeErreur;
    }

    /**
     * @return the codeErreur.
     */
    public QualitEnum getCodeErreur() {
        return codeErreur;
    }

    /**
     * @param paramCodeErreur the codeErreur to set.
     */
    public void setCodeErreur(QualitEnum paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }

    /**
     * @return the serialversionuid.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
