/**
 * 
 */
package fr.afcepf.al28.generic;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al28.tp.Personne;

/**
 * @author stagiaire
 *
 */
public class PersonneDaoImpl extends GenericDaoImpl<Personne, String> implements PersonneDao {
	
	@Override
	public List<Personne> recherchePersonnesMajeures() {
		List<Personne> listeP = new ArrayList<Personne>();
		for (Personne p : dataMap.values()) {
			if(p.getAge()>18) {
				listeP.add(p);
			}
		}
		return listeP;
	}

}
