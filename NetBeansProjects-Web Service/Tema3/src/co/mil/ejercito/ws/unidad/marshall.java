package co.mil.ejercito.ws.unidad;

import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * Fecha Sep 6, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
/**
 * GENERANDO UN UN XML DESDE JAVA  "marshall"
 *
 */


public class marshall {

    public static void main(String[] args) throws Exception{

        Unidad und = new Unidad();
        und.setId(56);
        und.setLugar("CAN");
        und.setNombre("GT");
        
        JAXBContext jc = JAXBContext.newInstance(Unidad.class);
        Marshaller m = jc.createMarshaller();
        OutputStream out  = new FileOutputStream("c:/unidad2.xml");
        //m.marshal(und, out);
        //System.out.println(und, out);
    }

}
