

package co.mil.ejercito.client;

/**
 *
 *Fecha     Sep 12, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
public class EmpleadosJacksonJersey {
    
    public static void main(String[] args)throws Exception{
        String contexURL = "http://win2003server:7001";        //IP y puerto del servidor
        String resourcePath = "/ConsultarDepartamentoRest/resources/ConsultasRestService";
        String requestPath = "/name/30";
        String urlString = contexURL + resourcePath + requestPath;
        
        Client client = Client.create();
        WebResource resource = client.resource(urlString);
        String result = resource.get(String.class);
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Empleado>> mapType = new TypeReference<List<Empleado>>(){};
        List<Empleado> emps = mapper.readValue(result, mapType);
        for (Empleado e : emps) {
            System.out.println(e.getNombre());
            
        }
        
  
        
        
    }

}
