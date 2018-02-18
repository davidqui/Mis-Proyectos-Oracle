package co.mil.ejercito.ws.unidad;

import co.mil.ejercito.ws.Person;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * Fecha Sep 6, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 * 
 * LEYENDO UN XML EN LA CONSOLA DE JAVA USANDO EL METODO " Unmarshaller"
 * 
 */


public class UnidadApp {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Unidad.class);
        Unmarshaller u = jc.createUnmarshaller();
        InputStream in = new FileInputStream("c:/unidad.xml");
        Unidad und = (Unidad) u.unmarshal(in);

        System.out.println("Id          : " + und.getId());

        System.out.println("Nombre      : " + und.getNombre());

        System.out.println("Lugar       : " + und.getLugar());

    }

}
