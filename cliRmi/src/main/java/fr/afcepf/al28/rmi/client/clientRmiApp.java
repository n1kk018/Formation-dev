package fr.afcepf.al28.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al28.rmi.serv.api.IRemoteCalculateur;
import fr.afcepf.al28.rmi.serv.data.Meteo;

public class clientRmiApp {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(args.length>=1?args[0]:"localhost",1099);
            IRemoteCalculateur proxyRemoteCalc = (IRemoteCalculateur) registry.lookup("remoteCalculateur");
            Double prixF = proxyRemoteCalc.eurosToFrancs(15.0);
            System.out.println("15 euros = "+ prixF + " francs");
            System.out.println("auteur = "+ proxyRemoteCalc.getAuteur());
            Meteo serializedMeteo = proxyRemoteCalc.meteoDuJour();
            System.out.println(serializedMeteo.getTemps());
        } catch (RemoteException paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        } catch (NotBoundException paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        }

    }

}
