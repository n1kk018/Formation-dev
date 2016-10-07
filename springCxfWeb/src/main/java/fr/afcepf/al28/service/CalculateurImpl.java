package fr.afcepf.al28.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService(endpointInterface="fr.afcepf.al28.service.ICalculateur")
@Service
public class CalculateurImpl implements ICalculateur {

    @Override
    public double addition(double paramV1, double paramV2) {
        System.out.println("========================>addition");
        return paramV1+paramV2;
    }

    @Override
    public double multiplication(double paramV1, double paramV2) {
        System.out.println("========================>multiplication");
        return paramV1*paramV2;
    }

}
