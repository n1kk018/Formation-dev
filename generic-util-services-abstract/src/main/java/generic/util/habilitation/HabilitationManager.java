package generic.util.habilitation;

import java.util.List;

/**
 * interface abstraite pour la gestion des habilitations
 * (ex: via ldap , fichier xml/properties , base de données , spring-security , ...)
 * 
 * En interne seulement , les rôles pourront éventuellement être associés à des groupes d'utilisateurs
 */

public interface HabilitationManager {
	
	/**
	 * @param userName
	 * @param contextHint (may be null) : eventuel context (ex: appName , serviceName , ...)
	 * @return liste des rôles de l'utilisateur (eventuellement vide)
	 */
	public List<String> getUserRoleList(String userName,String contextHint);
	
	/**
	 * @param username
	 * @param role à vérifier pour cet utilisateur
	 * @param contextHint (may be null) : eventuel context (ex: appName , serviceName , ...)
	 * @return true if user has role , false if has not.
	 * 
	 * L'implementation de cette méthode pourra souvent être basée sur la méthode "getUserRoleList"
	 */
	public boolean hasRole(String username,String role,String contextHint);
}
