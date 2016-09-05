/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.vin.data.exception;

/**
 * Erreurs renvoyees par notre appli
 * @author ronan
 */
public enum CodeErreurVin {
    /**
     * Liste de toutes les erreurs.
     */
    /**
     * Erreur générique.
     */
    CA_NE_FONCTIONNE_PAS,
    /**
     * Ajout dans la base impossible.
     */
    IMPOSSIBLE_AJOUT_DANS_BASE,
    /**
     * Suppression dans la base impossible.
     */
    IMPOSSIBLE_SUPPRESSION_DANS_BASE,
    /**
     * Objet demandé non présent en base.
     */
    RECHERCHE_NON_PRESENTE_EN_BASE,
    /**
     * L'update ne peut être faite.
     */
    UPDATE_NON_EFFECTUE_EN_BASE,
    /**
     * Login ou mot de pass invalide pour la
     * connection.
     */
    LOGIN_MDP_INVALIDE;
}
