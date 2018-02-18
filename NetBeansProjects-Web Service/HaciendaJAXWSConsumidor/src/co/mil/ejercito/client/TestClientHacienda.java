package co.mil.ejercito.client;

import co.mil.ejercito.ws.Impuesto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;
import weblogic.xml.crypto.wss.provider.CredentialProvider;

/**
 *
 * Fecha Sep 15, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestClientHacienda {

    public static void main(String[] args) {
        java.util.List<co.mil.ejercito.ws.Impuesto> lista = consultaImpuestoVehicular(new BigDecimal("809876671"));
        for (Impuesto lis : lista) {
            System.out.println("el Valor de la transaccion es : " + lis.getValor());
            
            System.out.println("el numero de transaccion es : " + lis.getNumeroTransaccion());
            
            System.out.println("el Formulario es : " + lis.getNumeroFormulario());
            
            System.out.println("el periodo es : " + lis.getPeriodo());
            
            

        }
      

    }

    private static java.util.List<co.mil.ejercito.ws.Impuesto> consultaImpuestoVehicular(java.math.BigDecimal cedula) {
        co.mil.ejercito.ws.HaciendaService_Service service = new co.mil.ejercito.ws.HaciendaService_Service();
        co.mil.ejercito.ws.HaciendaService port = service.getHaciendaServicePort();

        BindingProvider bindingProvider = (BindingProvider) port;
        String USERNAME = "weblogic";
        String PASSWORD = "Welcome1";
        Map<String, Object> rc = (Map<String, Object>) bindingProvider.getRequestContext();
        List<CredentialProvider> credProviders = new ArrayList<CredentialProvider>();
        credProviders.add(new ClientUNTCredentialProvider(USERNAME.getBytes(), PASSWORD.getBytes()));
        rc.put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credProviders);
        rc.put(BindingProvider.USERNAME_PROPERTY, USERNAME);
        rc.put(BindingProvider.PASSWORD_PROPERTY, PASSWORD);

        return port.consultaImpuestoVehicular(cedula);
    }

}
