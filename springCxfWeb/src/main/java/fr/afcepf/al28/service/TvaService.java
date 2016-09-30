package fr.afcepf.al28.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface TvaService {
    public Double tva(@WebParam(name="ht") Double ht, 
                      @WebParam(name="tauxPct") Double tauxPct);
    public Double ttc(@WebParam(name="ht")Double ht, 
                      @WebParam(name="tauxPct") Double tauxPct);
    public String getAuteur();
}
