package fr.afcepf.al28.livraison.biz.api;

import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * Service metiers lies a la preparation et la livraison d'une commande.
 * @author stagiaire
 *
 */
public interface IBusinessPreparateur {
    /**
     * Le preparateur cree une livraison pour une date de depart donnee, une commande donnees et un livreur donne.
     * @param liv la livraison
     * @return  la {@link Livraison} créée
     * @throws QualitException
     * <ul>
     *  <li>Pas de livreurs dispo à la date choisie<li>
     *  <li>couche de persistence leve une exception<li>
     * </ul>
     */
    Livraison creer(Livraison liv) throws QualitException;
}
