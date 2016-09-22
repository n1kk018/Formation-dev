package fr.afcepf.al28.livraison.data.api;

import fr.afcepf.al28.livraison.entities.Preparateur;
import fr.afcepf.al28.livraison.exceptions.QualitException;

/**
 * Services liés à la persistence de l'entité
 * {@link Preparateur}.
 * @author stagiaire
 *
 */
public interface IDaoPreparateur {
    /**
     * Méthode permettant de vérifier l'existence d'un {@link Preparateur}
     * dans l'unité de persistence à l'aide d'un login et d'un mot de passe.
     * @param login Le login.
     * @param mdp Le mot de passe.
     * @return un {@link Preparateur} existant.
     * @throws QualitException
     * <ul>
     *  <li>aucun {@link Preparateur} avec ce login/mdp.</li>
     *  <li>unité de persistence est cassée.</li>
     * </ul>
     */
    Preparateur seConnecter(String login, String mdp) throws QualitException;
}
