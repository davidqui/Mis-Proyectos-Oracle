/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


/**
 *
 * @author Administrator
 */
@WebService(serviceName = "SecurityService")
public class SecurityService {
    //PARA INTERACTUAR CON LA SEGURIDAD
    @Resource
    WebServiceContext wsctx;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        //INSPECCIONA LAS CABECERAS Y TRAE EL PASSWORD
        String retorno = "";
        MessageContext mctx = wsctx.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
        String username = "";
        String password = "";
        if (userList != null) {
            username = userList.get(0).toString();            
        }
        if (passList != null) {
            password = passList.get(0).toString();            
        }
        if (username.equals("usuario")&& password.equals("123")) {
            retorno = "Hello " + txt + " !" ;            
        }else{
        retorno = "Usuario Desconocido!";
        }
        
        
        return retorno;
    }
}
