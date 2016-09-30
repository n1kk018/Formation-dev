package fr.afcepf.al28.app;

import javax.xml.ws.Endpoint;

import fr.afcepf.al28.service.TvaServiceImpl;

public class ServSoapApp {

    public static void main(String[] args) {
        TvaServiceImpl tvaSrvImpl = new TvaServiceImpl();
        String endPointUrl = "http://localhost:8081/serviceTva";
        Endpoint.publish(endPointUrl, tvaSrvImpl);
        try {
            Thread.sleep(15*60*1000);
        } catch (InterruptedException paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        }//15 min
        System.out.println("Fin du programme serveur");
        System.exit(0);
    }

}
