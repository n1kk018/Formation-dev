package fr.afcepf.al28.client;

import fr.afcepf.al28.service.TvaService;
import fr.afcepf.al28.service.TvaServiceImplService;

public class ClientSoapApp {

    public static void main(String[] args) {
        TvaService client = (TvaService) (new TvaServiceImplService()).getTvaServiceImplPort();
        System.out.println("Auteur: " + client.getAuteur());
        System.out.println(client.tva(200D, 20D));
    }

}
