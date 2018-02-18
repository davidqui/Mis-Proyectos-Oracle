

package co.mil.ejercito.ws;

/**
 *
 *Fecha     Sep 11, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
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
@Path("CalcularRaiz")    //ALIAS EN LA "URL"
public class CalcularRaiz {
    @GET    //consultas
    @Produces(MediaType.TEXT_XML)//arroja un xml
    @Consumes(MediaType.TEXT_HTML)//recibe un xml
    @Path("/Raiz/{a}")      //SE DEFINE COMO SE VA A CONSUMIR ESTE METODO
    //le adiciona dentro de lo que recibe un "@PathParam("i")"
    public String consultarRaiz(@PathParam("a") int a){//recibe un String y devuelve un xml
       
        return "<Raiz>" + Math.sqrt(a) + "</Raiz>";
    }

}
