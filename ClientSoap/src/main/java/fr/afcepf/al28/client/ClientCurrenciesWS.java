package fr.afcepf.al28.client;

import fr.afcepf.atod.ws.currency.soap.CurrenciesWSException_Exception;
import fr.afcepf.atod.ws.currency.soap.CurrencyConverterService;
import fr.afcepf.atod.ws.currency.soap.ICurrencyConverter;

public class ClientCurrenciesWS {
    public static void main(String[] args) {
        //Soap client on EJB server with wsimport by maven
        ICurrencyConverter client = (ICurrencyConverter) (new CurrencyConverterService()).getCurrencyConverterPort();
        try {
            System.out.println(client.convert(10D, "EUR", "GBP"));
        } catch (CurrenciesWSException_Exception paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        }
    }
}
