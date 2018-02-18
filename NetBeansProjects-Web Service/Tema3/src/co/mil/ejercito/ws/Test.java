

package co.mil.ejercito.ws;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 *Fecha     Sep 6, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class Test {
    public static void main(String[] args) throws Exception{
        
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        Unmarshaller u = jc.createUnmarshaller();
        InputStream in = new FileInputStream("c:/persona.xml");
        Person p = (Person) u.unmarshal(in);
        System.out.println("Name    :" + p.getName());
        
    }

}
