package client.rest.jax_rs2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.codec.digest.DigestUtils;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
//import org.glassfish.jersey.filter.LoggingFilter;

public class RestClientWithBasicHttpAuth {
	public static void main(String[] args) {
		basicTestWithAuth();
	}
	public static void basicTestWithAuth(){	
		String password="superSecretPassword";
		String md5HexPassword = DigestUtils.md5Hex( password );
		System.out.println("md5HexPassword="+md5HexPassword);
		HttpAuthenticationFeature httpAuthFeature = HttpAuthenticationFeature.basic("user", md5HexPassword);

		
		Client jaxrs2client = ClientBuilder.newClient()
				                           //.register(new LoggingFilter())
				                           .register(httpAuthFeature);
		WebTarget allDevisesJsonTarget = jaxrs2client.target("http://localhost:8080/wsCalculateur/services/rest/devises").path("allJson");
		String resultString = allDevisesJsonTarget.request().get(String.class);
		System.out.println("liste des devises:\n\t " +resultString);
		
		//NB: ceci est un simple debut de securisation des appels HTTP/REST
		// le coté serveur n'est pas (encore) securisé (faute de temps).
		
		//piste1 (générale) : utiliser "salt" en plus
		//piste2 (générale) : utiliser "ssl/https" en plus
		
		//pour les clients "javascript" :
		// HTML5 encryption et/ou crypto-js (de google):
		//exemple:
		//<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/md5.js"></script>
		//<script>
		//    var hash = CryptoJS.MD5("Message");
		//</script>
		
		//pour le coté serveur (java) : trouver ou coder un intercepteur (selon techno CXF , jersey , Spring-mvc , ...)
		
		//pour envoyer les infos d'auth depuis un appel ajax:
		// v1 (via jQuery) : 
		/*
		 var username = $("input#username").val();
			var password = $("input#password").val();  
			
			function make_base_auth(user, password) {
			  var tok = user + ':' + password;
			  var hash = btoa(tok);
			  return "Basic " + hash;
			}
			$.ajax
			  ({
			    type: "GET",
			    url: "index1.php",
			    dataType: 'json',
			    async: false,
			    data: '{}',
			    beforeSend: function (xhr){ 
			        xhr.setRequestHeader('Authorization', make_base_auth(username, password)); 
			    },
			    success: function (){
			        alert('Thanks for your comment!'); 
			    }
			});
		 */
		// V2 (via Angular Js):
		/*
		 $http.defaults.headers.common = {"Access-Control-Request-Headers": "accept, origin, authorization"}; //for CORS
    	$http.defaults.headers.common['Authorization'] = 'Basic ' + Base64.encode('admin' + ':' + 'abc12345');
    	$http({method: 'GET', url: 'http://localhost:8888/app/api/v1/pets'}).
            success(function(data, status, headers, config) {
               ..
            }).
            error(function(data, status, headers, config) {
               ...
            }); 
		 */
		
		
	}
}
