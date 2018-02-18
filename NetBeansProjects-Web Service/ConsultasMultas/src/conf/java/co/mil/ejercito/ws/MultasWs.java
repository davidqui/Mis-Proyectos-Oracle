

package co.mil.ejercito.ws;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 *Fecha     Sep 8, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class MultasWs implements Serializable{
    private BigDecimal id;
    private String descripcion;
    private String valor;
    private int id_ciudadano;

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the id_ciudadano
     */
    public int getId_ciudadano() {
        return id_ciudadano;
    }

    /**
     * @param id_ciudadano the id_ciudadano to set
     */
    public void setId_ciudadano(int id_ciudadano) {
        this.id_ciudadano = id_ciudadano;
    }

    
}
