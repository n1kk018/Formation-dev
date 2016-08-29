/**
 * 
 */
package fr.afcepf.al28.generic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fr.afcepf.al28.reflection.ConsoleApp;
import fr.afcepf.al28.tp.Personne;

/**
 * implémentation générique simulée (sans vrai database, tout en mémoire)
 * 
 * @author stagiaire
 *
 */
public class GenericDaoImpl<E, ID extends Serializable> implements GenericDao<E, ID> {
	
	//simulation BDD
	protected Map<ID,E> dataMap = new HashMap<ID,E>();

	@Override
	public E findEntity(ID id) {
		return dataMap.get(id);
	}

	@Override
	public void deleteEntity(E e) {
		for(Entry<ID,E> entry : dataMap.entrySet()) {
			if(entry.getValue().equals(e)) {
				dataMap.remove(entry.getKey());
				break;
			}
		}
		
	}

	@Override
	public ID insertEntity(E e) {
		dataMap.put((ID)ConsoleApp.getPrimaryKeyOfObject(e), e);
		return (ID)ConsoleApp.getPrimaryKeyOfObject(e);
	}

	@Override
	public void updateEntity(E e) {
		dataMap.put((ID)ConsoleApp.getPrimaryKeyOfObject(e), e);
	}

}
