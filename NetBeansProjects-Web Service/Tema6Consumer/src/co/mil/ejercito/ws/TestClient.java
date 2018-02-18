

package co.mil.ejercito.ws;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 *
 *Fecha     Sep 15, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestClient {
    
    public static void main(String[] args) {
        String ContextURL = "http://192.168.252.72:7001/Tema6/resources";
        String resourcePath = "/RestService";
        String requestPath = "/name/david";
        
        String urlString = ContextURL + resourcePath + requestPath;
        Client client = Client.create();
        ClientFilter authFilter = new HTTPBasicAuthFilter("davidquij", "Welcome1");
        client.addFilter(authFilter);
        WebResource resource = client.resource(urlString);
        String result = resource.get(String.class);
        System.out.println(result);
        
    }

}
