

package co.mil.ejercito.ws;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 6, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@XmlRootElement
public class Person {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
