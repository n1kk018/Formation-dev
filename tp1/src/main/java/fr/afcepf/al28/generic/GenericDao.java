package fr.afcepf.al28.generic;

import java.io.Serializable;

/**
 * 
 * @author stagiaire
 *
 * @param <E> : Type d'entité (Personne, Avion, ...)
 * @param <ID> : Type de clef primaire (Integer, String, Long, ...)
 */

public interface GenericDao<E, ID extends Serializable> {
	E findEntity(ID id);
	void deleteEntity(E e);
	ID insertEntity(E e);
	void updateEntity(E e);
}
