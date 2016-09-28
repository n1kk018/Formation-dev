package fr.afcepf.al28.rmi.serv.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.afcepf.al28.rmi.serv.api.IRemoteCalculateur;
import fr.afcepf.al28.rmi.serv.data.Meteo;

public class RemoteCalculateur extends UnicastRemoteObject implements IRemoteCalculateur {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public RemoteCalculateur() throws RemoteException {
        super();//pour que cet objet soit accessible via RMI
    }

    @Override
    public Double eurosToFrancs(Double paramMontantEuros) {
        return paramMontantEuros * 6.55957;
    }

    @Override
    public String getAuteur() {
        return "nikko";
    }

    @Override
    public Meteo meteoDuJour() {
        return new Meteo(15.0, "beau temps");
    }

}
