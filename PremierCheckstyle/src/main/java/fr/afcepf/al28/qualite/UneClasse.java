package fr.afcepf.al28.qualite;
/**
 * une classe pour voir qu'on ne sait pas ecrire.
 * @author stagiaire
 *
 */

public class UneClasse {
    /**
     * un attribut inutile.
     */
    private int att1;
    /**
     * un autre attribut.
     */
    private String att2;
    /**
     * Constructeur vide.
     */
    public UneClasse() {
        super();
    }
    /**
     * Méthode qui retourne "coucou".
     * @param i njmo.
     * @return une chaine
     * <code>
     *  <ul>
     *      <li><b>"coucou"</b></li>
     *  </ul>
     * </code>
     */
    public String methode(int i) {
        return "coucou";
    }
    /**
     * @return the att1
     */
    public int getAtt1() {
        return att1;
    }
    /**
     * @param paramAtt1 the att1 to set
     */
    public void setAtt1(int paramAtt1) {
        att1 = paramAtt1;
    }
    /**
     * @return the att2
     */
    public final String getAtt2() {
        return att2;
    }
    /**
     * @param paramAtt2 the att2 to set
     */
    public void setAtt2(String paramAtt2) {
        att2 = paramAtt2;
    }
    /**
     * Constructeur surchargé.
     * @param paramAtt1 valeur de att1
     * @param paramAtt2 valeeur de att2
     */
    public UneClasse(int paramAtt1, String paramAtt2) {
        super();
        att1 = paramAtt1;
        att2 = paramAtt2;
    }
}
