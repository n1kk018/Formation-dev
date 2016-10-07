package generic.util.auth;

/**
 * 
 * @author didier defrance
 * 
 * interface abstraite d'un gestionnaire d'authentification 
 * (ex: via ldap , fichier xml/properties , base de données , spring-security , ...)
 * 
 * Au moins une des 2 méthodes devra être implémentée (idéalement les deux).
 * 
 * Si ce service est distant , les messages de requête/réponse devront evidemment être cryptés (ex: https)
 *
 */
public interface AuthManager {
	
	/**
	 * @param username
	 * @param password
	 * @return true if valid auth , false if wrong auth , null if n/a (not implemented)
	 */
	public Boolean verifyAuth(String username,String password);
	
	
	
	/**
	 * @param username
	 * @return valid password for user if user exist
	 *         null if user doesn't exist or if not implemented
	 *         
	 * NB: une callback ws-security a absolument besoin de cette méthode
	 *     qui doit donc être implémentée        
	 */
	public String getValidPasswordForUser(String username);
}
