package fr.afcepf.al28.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService
public interface ICalculateur {
    public double addition(@WebParam(name="v1")double v1, @WebParam(name="v2")double v2);
    public double multiplication(@WebParam(name="v1")double v1, @WebParam(name="v2")double v2);
}
