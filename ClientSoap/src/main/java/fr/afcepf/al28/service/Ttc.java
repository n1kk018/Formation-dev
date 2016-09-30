
package fr.afcepf.al28.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ttc complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ttc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ht" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tauxPct" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ttc", propOrder = {
    "ht",
    "tauxPct"
})
public class Ttc {

    protected Double ht;
    protected Double tauxPct;

    /**
     * Obtient la valeur de la propriété ht.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHt() {
        return ht;
    }

    /**
     * Définit la valeur de la propriété ht.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHt(Double value) {
        this.ht = value;
    }

    /**
     * Obtient la valeur de la propriété tauxPct.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTauxPct() {
        return tauxPct;
    }

    /**
     * Définit la valeur de la propriété tauxPct.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTauxPct(Double value) {
        this.tauxPct = value;
    }

}
