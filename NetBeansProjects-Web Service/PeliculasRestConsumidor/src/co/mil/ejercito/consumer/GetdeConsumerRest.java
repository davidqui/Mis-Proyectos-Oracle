package co.mil.ejercito.consumer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * Fecha Sep 26, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class GetdeConsumerRest {

    public static void main(String[] args) {
        String confirmacion = guardarReserva("a", "b", "c", "1");
        System.out.println(confirmacion);
    }

    public static String guardarReserva(String descripcion, String funcion, String ubicacion, String id) {
        String contextURL = "http://win2003server:7001";
        String resourcePath = "/PeliculasRest/resources";
        String requestPath = "/ReservasRestService/guardarReserva/" 
                + descripcion + "/"
                + funcion + "/" + ubicacion + "/" + id;

        String urlString = contextURL + resourcePath + requestPath;
        Client client = Client.create();
        WebResource resource = client.resource(urlString);
        String result = resource.put(String.class);
        //System.out.println(result);
        return result;
    }

}
