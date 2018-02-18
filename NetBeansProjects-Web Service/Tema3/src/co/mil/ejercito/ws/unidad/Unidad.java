

package co.mil.ejercito.ws.unidad;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 6, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@XmlRootElement
public class Unidad {
    private long id;
    private String nombre;
    private String lugar;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    

}
