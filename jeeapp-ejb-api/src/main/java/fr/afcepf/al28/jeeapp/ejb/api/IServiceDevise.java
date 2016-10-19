package fr.afcepf.al28.jeeapp.ejb.api;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al28.jeeapp.ejb.dto.DeviseDTO;
import fr.afcepf.al28.jeeapp.ejb.dto.PaysDTO;
import fr.afcepf.al28.jeeapp.entity.Pays;

//@Local
@Remote
@WebService
public interface IServiceDevise 
{
	public DeviseDTO rechercherDevise(@WebParam(name="codeDevise") String codeDevise);
	public List<DeviseDTO> toutesDevises();
	public Double convertir(@WebParam(name="montant") Double montant, @WebParam(name="devSource") String devSource, @WebParam(name="devCible") String devCible);
	public List<PaysDTO> listePaysPartageantDevise(@WebParam(name="devise") String devise);
}
