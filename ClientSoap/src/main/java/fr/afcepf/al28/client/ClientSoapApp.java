package fr.afcepf.al28.client;

import fr.afcepf.al28.soap.devise.DeviseDTO;
import fr.afcepf.al28.soap.devise.IServiceDevise;
import fr.afcepf.al28.soap.devise.ServiceDeviseBeanService;

/*import fr.afcepf.al28.service.TvaService;
import fr.afcepf.al28.service.TvaServiceImplService;*/

public class ClientSoapApp {

    public static void main(String[] args) {
        //Soap client with wsimport batch
        /*TvaService client = (TvaService) (new TvaServiceImplService()).getTvaServiceImplPort();
        System.out.println("Auteur: " + client.getAuteur());
        System.out.println(client.tva(200D, 20D));*/
        //Soap client on EJB server with wsimport by maven
        IServiceDevise client = (IServiceDevise) (new ServiceDeviseBeanService()).getServiceDeviseBeanPort();
        DeviseDTO dev = client.rechercherDevise("EUR");
        System.out.println("dev="+dev.getMonnaie()+" - "+dev.getTauxChange());
    }

}
