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
     * ayant un état "a preparer".
     * @return
     * <ul>
     *  <li><strong>toutes</strong>les {@link Commande} trouvees dans l'unite de persistence.</li>
     *  <li>une {@link List} si tout a deja ete livre.</li>
     * </ul>
     * @throws QualitException
     * <ul>
     * <li>si l'unité de persistence ne repond pas</li>
     * <li>erreur de dev</li>
     * </ul>
     */
    List<Commande> rechercherCommandeAExpedier() throws QualitException;
    /**
     * Permet de mettre à jour une {@link Commande} dans l'unite de persistence.
     * @param cmd la {@link Commande} modifiee.
     * @return la {@link Commande} modifiee.
     * @throws QualitException
     * <ul>
     *  <li>un attribut obligatoire non renseigne.</li>
     *  <li>la {@link Commande} n'existe pas<li>
     *  <li>si l'unité de persistence ne repond pas</li>
     *  <li>erreur de dev, mais faut pas le dire</li>
     * </ul>
     */
    Commande maj(Commande cmd) throws QualitException;
}
