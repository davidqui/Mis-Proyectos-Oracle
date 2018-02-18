package co.mil.ejercito.aplicacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * Fecha Sep 29, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */

@Entity
public class BuscarVivienda implements Serializable {

    @Id
    @Column(name = "ID")
    private BigDecimal id ;
   // @Column(name = "DESCRI_V")
    //private String descriV;
   @Column(name = "CANT_BANOS")
    private BigInteger cantBanos;
    @Column(name = "CANT_HABITACIONES")
    private BigInteger cantHabitaciones;
    @Column(name = "CANT_PISOS")
    private BigInteger cantPisos;
    @Size(max = 50)
    @Column(name = "UBICACION_PISO")
    private String ubicacionPiso;
    @Size(max = 10)
    @Column(name = "GARAJE")
    private String garaje;
    @Size(max = 10)
    @Column(name = "GAS")
    private String gas;
    @Size(max = 10)
    @Column(name = "ENERGIA")
    private String energia;
    @Size(max = 10)
    @Column(name = "AGUA")
    private String agua;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 150)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "CIUDAD")
    private String ciudad;
    @Size(max = 30)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 10)
    @Column(name = "ANO_CONST")
    private String anoConst;
    @Size(max = 20)
    @Column(name = "AREA_CONST")
    private String areaConst;
      @Column(name = "PRECIO")
    private BigInteger precio;
      @Size(min = 1, max = 100)
    @Column(name = "DESCRI_C")
    private String descriC;

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
     * @return the cantBanos
     */
    public BigInteger getCantBanos() {
        return cantBanos;
    }

    /**
     * @param cantBanos the cantBanos to set
     */
    public void setCantBanos(BigInteger cantBanos) {
        this.cantBanos = cantBanos;
    }

    /**
     * @return the cantHabitaciones
     */
    public BigInteger getCantHabitaciones() {
        return cantHabitaciones;
    }

    /**
     * @param cantHabitaciones the cantHabitaciones to set
     */
    public void setCantHabitaciones(BigInteger cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    /**
     * @return the cantPisos
     */
    public BigInteger getCantPisos() {
        return cantPisos;
    }

    /**
     * @param cantPisos the cantPisos to set
     */
    public void setCantPisos(BigInteger cantPisos) {
        this.cantPisos = cantPisos;
    }

    /**
     * @return the ubicacionPiso
     */
    public String getUbicacionPiso() {
        return ubicacionPiso;
    }

    /**
     * @param ubicacionPiso the ubicacionPiso to set
     */
    public void setUbicacionPiso(String ubicacionPiso) {
        this.ubicacionPiso = ubicacionPiso;
    }

    /**
     * @return the garaje
     */
    public String getGaraje() {
        return garaje;
    }

    /**
     * @param garaje the garaje to set
     */
    public void setGaraje(String garaje) {
        this.garaje = garaje;
    }

    /**
     * @return the gas
     */
    public String getGas() {
        return gas;
    }

    /**
     * @param gas the gas to set
     */
    public void setGas(String gas) {
        this.gas = gas;
    }

    /**
     * @return the energia
     */
    public String getEnergia() {
        return energia;
    }

    /**
     * @param energia the energia to set
     */
    public void setEnergia(String energia) {
        this.energia = energia;
    }

    /**
     * @return the agua
     */
    public String getAgua() {
        return agua;
    }

    /**
     * @param agua the agua to set
     */
    public void setAgua(String agua) {
        this.agua = agua;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the anoConst
     */
    public String getAnoConst() {
        return anoConst;
    }

    /**
     * @param anoConst the anoConst to set
     */
    public void setAnoConst(String anoConst) {
        this.anoConst = anoConst;
    }

    /**
     * @return the areaConst
     */
    public String getAreaConst() {
        return areaConst;
    }

    /**
     * @param areaConst the areaConst to set
     */
    public void setAreaConst(String areaConst) {
        this.areaConst = areaConst;
    }

    /**
     * @return the precio
     */
    public BigInteger getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    /**
     * @return the descriC
     */
    public String getDescriC() {
        return descriC;
    }

    /**
     * @param descriC the descriC to set
     */
    public void setDescriC(String descriC) {
        this.descriC = descriC;
    }
      
      
}
