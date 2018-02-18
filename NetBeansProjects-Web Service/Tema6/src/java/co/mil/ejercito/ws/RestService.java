

package co.mil.ejercito.ws;


import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 *Fecha     Sep 11, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Path("RestService")    //ALIAS EN LA "URL"
public class RestService {
    @GET    //consultas
    @Produces(MediaType.TEXT_XML)//arroja un xml
    @Consumes(MediaType.TEXT_XML)//recibe un xml
    @Path("/name/{i}")      //SE DEFINE COMO SE VA A CONSUMIR ESTE METODO
    //le adiciona dentro de lo que recibe un "@PathParam("i")"
    public String consultarNombreUsuario(@PathParam("i") String i){//recibe un String y devuelve un xml
        String name = i;
        return "<User>" + "<Name>" + name + "</Name>" + "</User>";
    }

}
