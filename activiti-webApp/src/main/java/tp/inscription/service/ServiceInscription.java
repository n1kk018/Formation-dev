package tp.inscription.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.inscription.data.Inscription;

@WebService
public interface ServiceInscription {
	
	public String traiterInscription(@WebParam(name="inscription")Inscription inscription);

}
