package fr.afcepf.al28.livraison.data.api;

import java.util.List;

import fr.afcepf.al28.livraison.entities.Commande;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * Services liés à la persistence de l'entité
 * {@link Commande}.
 * @author stagiaire
 *
 */
public interface IDaoCommande {
    /**
     * Permet de echercherdes {@link Commande}
     * ayant un état "à préparer".
     * @return
     * <ul>
     *  <li><strong>toutes</strong> les {@link Commandde} trouvées
     *  dans l'unité de persistence.</li>
     *  <li>une {@link List} si tout à déjà été livré.</li>
     * </ul>
     * @throws QualitException
     * <ul>
     * <li>si l'unité de persistence ne répond pas</li>
     * <li>erreur de dev</li>
     * </ul>
     */
    List<Commande> rechercherCommandeAExpedier() throws QualitException;
    /**
     * Permet de mettre à jour une {@link Commande} dans l'unité de persistence.
     * @param cmd la {@link Commande} modifiée.
     * @return la {@link Commande} modifiée.
     * @throws QualitException
     * <ul>
     *  <li>un attribut obligatoire non renseigné.</li>
     *  <li>la {@link Commande} n'existe pas<li>
     *  <li>si l'unité de persistence ne répond pas</li>
     *  <li>erreur de dev, mais faut pas le dire</li>
     * </ul>
     */
    Commande maj(Commande cmd) throws QualitException;
}
