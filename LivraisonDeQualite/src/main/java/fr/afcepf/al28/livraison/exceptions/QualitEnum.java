package fr.afcepf.al28.livraison.exceptions;

/**
 * Enumeration des erreurs possibles.
 * @author stagiaire
 *
 */

public enum QualitEnum {
    /**
     * Erreur si le métier ne trouva pas de livreur dispo lors de la création de la livraison.
     */
    PAS_DE_LIVREUR_DISPO,
    /**
     * Le serveur de données ne répond pas..
     */
    PROBLEME_CONNECTION_SQL,
    /**
     * Mauvais Login/Password.
     */
    PROBLEME_IDENTIFICATION,
    /**
     * Erreur Non Identifiée.
     */
    CA_MARCHE_PAS
}
