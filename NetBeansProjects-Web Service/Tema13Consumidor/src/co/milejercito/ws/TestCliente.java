

package co.milejercito.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;
import weblogic.xml.crypto.wss.provider.CredentialProvider;

/**
 *
 *Fecha     Sep 15, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestCliente {
    
    public static void main(String[] args) {
        
        String respuesta = hello("Mundo");
        System.out.println(respuesta);
        
    }

    private static String hello(java.lang.String name) {
        co.mil.ejercito.ws.SecurityService_Service service = new co.mil.ejercito.ws.SecurityService_Service();
        co.mil.ejercito.ws.SecurityService port = service.getSecurityServicePort();
        
        BindingProvider bindingProvider = (BindingProvider) port;
        String USERNAME = "weblogic";
        String PASSWORD = "Welcome1";
        Map<String, Object> rc = (Map<String, Object>) bindingProvider.getRequestContext();
        List<CredentialProvider> credProviders = new ArrayList<CredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(USERNAME.getBytes(), PASSWORD.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
        rc.put(BindingProvider.USERNAME_PROPERTY, USERNAME);
        rc.put(BindingProvider.PASSWORD_PROPERTY, PASSWORD);
        
                
        return port.hello(name);
    }

}
