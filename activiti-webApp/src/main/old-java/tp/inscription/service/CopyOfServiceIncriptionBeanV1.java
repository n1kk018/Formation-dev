package tp.inscription.service;

import javax.jws.WebService;

import tp.inscription.context.InscriptionProcessContext;
import tp.inscription.data.Inscription;

@WebService(endpointInterface="tp.inscription.service.ServiceInscription")
public class CopyOfServiceIncriptionBeanV1 implements ServiceInscription {
	
	private InscriptionProcessContext inscriptionProcessContext;
	
	
    //injection method for Spring
	public void setInscriptionProcessContext(
			InscriptionProcessContext inscriptionProcessContext) {
		this.inscriptionProcessContext = inscriptionProcessContext;
	}

	@Override
	public String traiterInscription(Inscription inscription) {
		return inscriptionProcessContext.traiterInscription(inscription);
	}

}
