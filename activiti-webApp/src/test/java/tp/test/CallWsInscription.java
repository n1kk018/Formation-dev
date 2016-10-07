package tp.test;

import generic.ws.util.client.DynReflectSoapClient;
import tp.inscription.data.Inscription;

public class CallWsInscription {

	public static void main(String[] args) {
		DynReflectSoapClient dynReflectSoapClient = new DynReflectSoapClient();
		Inscription nouvelleInscription = new Inscription();
		nouvelleInscription.setNumInscription(1234);
		nouvelleInscription.setEmail("user1@localhost");
		nouvelleInscription.setName("user1 (power user");
		nouvelleInscription.setAdresse("2 rue Elle 75000 Par ici");
		String result = (String) dynReflectSoapClient.dynSoapCall("http://localhost:8080/activiti-webApp/services/serviceInscription",
				                        "tp.inscription.service.ServiceInscription", 
				                        "traiterInscription", nouvelleInscription);
	   System.out.println("result:"+result);
	}

}
