package fr.afcepf.al28.rmi.serv.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.afcepf.al28.rmi.serv.data.Meteo;

public interface IRemoteCalculateur extends Remote{
    Double eurosToFrancs(Double montantEuros) throws RemoteException;
    String getAuteur() throws RemoteException;
    Meteo meteoDuJour() throws RemoteException;
}
