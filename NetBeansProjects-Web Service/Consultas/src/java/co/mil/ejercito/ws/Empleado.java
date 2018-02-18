

package co.mil.ejercito.ws;

import java.io.Serializable;

/**
 *
 *Fecha     Sep 8, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class Empleado implements Serializable{
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String numeroTel;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the numeroTel
     */
    public String getNumeroTel() {
        return numeroTel;
    }

    /**
     * @param numeroTel the numeroTel to set
     */
    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
    
    

}
