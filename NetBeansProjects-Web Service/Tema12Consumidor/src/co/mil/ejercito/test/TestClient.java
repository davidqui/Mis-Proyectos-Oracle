

package co.mil.ejercito.test;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 *Fecha     Sep 14, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestClient {
    
    private static String WS_URL = "http://192.168.252.72:7001/Tema12/SecurityService?WSDL";
    
    public static void main(String[] args) {
        String resultado = hello("  Mundo");
        System.out.println(resultado);
        
    }

    private static String hello(java.lang.String name) {
        co.mil.ejercito.client.SecurityService_Service service = new co.mil.ejercito.client.SecurityService_Service();
        co.mil.ejercito.client.SecurityService port = service.getSecurityServicePort();
        
        //%%%%%%%%%%%%%%%%%%%%%%le insertamos el usuario y password en la cabecera%%%%%%%%%%%%%%%%%%%%%%%%%%
        
        Map<String, Object> req_ctx = ((BindingProvider)port).getRequestContext();//se octiene el Map, donde voy a colocar el "user" y "Pasword"
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);//coloca
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("usuario"));
        headers.put("Password", Collections.singletonList("123"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);//ESCRIBRE EN LA CABECERA
        
        return port.hello(name);
    }
    

}
