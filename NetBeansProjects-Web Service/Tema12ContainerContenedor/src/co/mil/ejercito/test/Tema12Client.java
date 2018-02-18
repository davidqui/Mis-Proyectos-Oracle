

package co.mil.ejercito.test;

import javax.xml.ws.BindingProvider;

/**
 *
 *Fecha     Sep 14, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class Tema12Client {
    public static void main(String[] args) {
        String resultado = hello("Mundo");
        System.out.println(resultado);
        
    }

    private static String hello(java.lang.String name) {
        co.mil.ejercito.ws.SecurityService_Service service = new co.mil.ejercito.ws.SecurityService_Service();
        co.mil.ejercito.ws.SecurityService port = service.getSecurityServicePort();
        
       ((BindingProvider)port).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "DavidQuijano");//autenticacion
       ((BindingProvider)port).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Welcome1");
                
        return port.hello(name);
    }

}
