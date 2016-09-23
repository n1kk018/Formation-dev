package fr.afcepf.al28.livraison.data.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.al28.livraison.entities.Livraison;
import fr.afcepf.al28.livraison.entities.Livreur;
import fr.afcepf.al28.livraison.exceptions.QualitException;
/**
 * Services liés à la persistence de l'entité
 * {@link Livreur}.
 * @author stagiaire
 *
 */
public interface IDaoLivreur {
    /**
     * Méthode permettant de rechercher tous le {@link Livraison} disponibles à
     * une date (et heure) donnée.
     * @param date la date recherchée
     * @return
     * <ul>
     *  <li>Tous les {@link Livreur} disponibles</li>
     *  <li>une {@link List} vide si pas de dispo</li>
     * </ul>
     * @throws QualitException
     * <ul>
     *  <li>unité de persistence ne répond pas</li>
     *  <li>erreur de dev</li>
     * </ul>
     */
    List<Livreur> rechercher(Date date) throws QualitException;
}
