package fr.afcepf.al28.rmi.serv.app;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al28.rmi.serv.impl.RemoteCalculateur;

public class ServRmiApp {

    public static void main(String[] args) {
        try {
            System.out.println("instantiation objet distant");
            RemoteCalculateur objRMI = new RemoteCalculateur();
            System.out.println("demarrage du register sur port 1099");
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("enregistrement avec nom=calculateur");
            registry.rebind("calculateur", objRMI);
            System.out.println("serveur pret, en attente des requetes");
        } catch (RemoteException paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        }

    }

}
