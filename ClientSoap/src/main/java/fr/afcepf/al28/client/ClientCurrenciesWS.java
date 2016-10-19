package fr.afcepf.al28.client;
import fr.afcepf.al28.soap.currency.CurrenciesWSException_Exception;
import fr.afcepf.al28.soap.currency.CurrencyConverterService;
import fr.afcepf.al28.soap.currency.ICurrencyConverter;

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
