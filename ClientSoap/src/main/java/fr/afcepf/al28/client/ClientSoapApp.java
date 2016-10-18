package fr.afcepf.al28.client;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import fr.afcepf.al28.soap.devise.DeviseDTO;
import fr.afcepf.al28.soap.devise.IServiceDevise;
import fr.afcepf.al28.soap.devise.ServiceDeviseBeanService;
import fr.afcepf.atod.ws.currency.soap.CurrenciesWSException_Exception;
import fr.afcepf.atod.ws.currency.soap.CurrencyConverterService;
import fr.afcepf.atod.ws.currency.soap.DtCurrency;
import fr.afcepf.atod.ws.currency.soap.ICurrencyConverter;

/*import fr.afcepf.al28.service.TvaService;
import fr.afcepf.al28.service.TvaServiceImplService;*/

public class ClientSoapApp {

    public static void main(String[] args) {
        //Soap client with wsimport batch
        /*TvaService client = (TvaService) (new TvaServiceImplService()).getTvaServiceImplPort();
        System.out.println("Auteur: " + client.getAuteur());
        System.out.println(client.tva(200D, 20D));*/
        //Soap client on EJB server with wsimport by maven
        /*IServiceDevise client = (IServiceDevise) (new ServiceDeviseBeanService()).getServiceDeviseBeanPort();
        DeviseDTO dev = client.rechercherDevise("EUR");
        System.out.println("dev="+dev.getMonnaie()+" - "+dev.getTauxChange());*/
        ICurrencyConverter client = (ICurrencyConverter) (new CurrencyConverterService()).getCurrencyConverterPort();
       try {
        System.out.println(client.convert(15.0, "USD", "EUR"));
    } catch (CurrenciesWSException_Exception paramE) {
        // TODO Auto-generated catch block
        paramE.printStackTrace();
    }
        //On teste du REST aussi
        /*try {
            String restAppPart = "/springCxfWeb/services/rest";
            URIBuilder builder = new URIBuilder();
            builder.setScheme("http").setHost("localhost").setPort(8080)
            .setPath(restAppPart + "/tva/calcul")
            .setParameter("ht", "200")
            .setParameter("tauxPct", "40");
            String url = builder.build().toString();
            System.out.println("REST GET URL="+url);
            HttpResponse response = (new DefaultHttpClient()).execute((new HttpGet(url)));
            String res=EntityUtils.toString(response.getEntity());
            JSONObject obj = new JSONObject(res);
            System.out.println("Prix ttc est égal à : " + obj.getDouble("ttc")); 
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
