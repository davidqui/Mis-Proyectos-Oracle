package co.mil.ejercito.multas;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * Fecha Sep 8, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestMulta {

    public static void main(String[] args) {
        List<co.mil.ejercito.wsclient.MultasWs> lista
                = consultarCiudadanoMultas(new BigDecimal(1));// BigDecimal ES UN OBJETOS

        for (co.mil.ejercito.wsclient.MultasWs mult : lista) {
            System.out.println("Descripcion: " + mult.getDescripcion());

            System.out.println("Valor: " + mult.getValor());

        }

    }

    //ARTEFACTOS EN CODIGO "JAVA"
//ABSTRACCION DE LA COMPLEJIDAD
    
    private static java.util.List<co.mil.ejercito.wsclient.MultasWs> consultarCiudadanoMultas(java.math.BigDecimal id) {
        co.mil.ejercito.wsclient.ConsultasService_Service service = new co.mil.ejercito.wsclient.ConsultasService_Service();
        co.mil.ejercito.wsclient.ConsultasService port = service.getConsultasServicePort();
        return port.consultarCiudadanoMultas(id);
    }

}
