package fr.afcepf.al28.livraison.data.api;

import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.exceptions.QualitException;
/**
 * Services liés à la persistence de l'entité
 * {@link Livraison}.
 * @author stagiaire
 *
 */
public interface IDaoLivraison {
    /**
     * Méthode permet de faire persister une {@link Livraison}.
     * @param liv la {@link Livraison}.
     * @return
     * la {@link Livraison} non transient.
     * @throws QualitException
     * <ul>
     *  <li>propriété obligatoire non renseignée ou au mauvais formart</li>
     *  <li>livraison existe déjà</li>
     *  <li>unité de persistence ne répond pas</li>
     *  <li>erreur de dev</li>
     * </ul>
     */
    Livraison creer(Livraison liv) throws QualitException;
}
