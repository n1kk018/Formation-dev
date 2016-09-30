package fr.afcepf.al28.service;

import javax.jws.WebService;

@WebService(endpointInterface="fr.afcepf.al28.service.TvaService")
public class TvaServiceImpl implements TvaService {

    @Override
    public Double tva(Double paramHt, Double paramTauxPct) {
        return paramHt * paramTauxPct/100;
    }

    @Override
    public Double ttc(Double paramHt, Double paramTauxPct) {
        return paramHt*(1+paramTauxPct/100);
    }

    @Override
    public String getAuteur() {
        return "nikko";
    }

}
