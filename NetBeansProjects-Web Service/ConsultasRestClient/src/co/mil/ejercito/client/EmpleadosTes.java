


package co.mil.ejercito.client;
 

/**
 *
 *Fecha     Sep 12, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
public class EmpleadosTes {
    
    public static void main(String[] args)throws Exception{
        String contexURL = "http://win2003server:7001"; 
        //String contexURL = "http://192.168.252.72:7001";        //IP y puerto del servidor
        String resourcePath = "/ConsultarDepartamentoRest/resources/ConsultasRestService";
        String requestPath = "/name/30";
        String urlString = contexURL + resourcePath + requestPath;
        
        
        
        URL url = new URL(urlString);
        InputStream result = (InputStream) url.getContent();
        Scanner scanner = new Scanner(result);
        System.out.println("Result  :" + scanner.next());
        
        
        
        
    }

}
