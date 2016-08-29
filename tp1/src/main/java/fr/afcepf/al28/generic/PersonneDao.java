/**
 * 
 */
package fr.afcepf.al28.generic;

import java.util.List;

import fr.afcepf.al28.tp.Personne;

/**
 * @author stagiaire
 *
 */
public interface PersonneDao extends GenericDao<Personne, String> {
	List<Personne> recherchePersonnesMajeures();
}
