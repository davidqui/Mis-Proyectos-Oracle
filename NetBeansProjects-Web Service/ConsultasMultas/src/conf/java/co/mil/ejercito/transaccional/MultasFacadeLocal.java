/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.transaccional;

import java.math.BigDecimal;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface MultasFacadeLocal {
    //se declara el metodo par crear
    public boolean crearCiudadano(String nombre, String apellido, String email, String telefono);
    
    //se declara el metodo par Borrar
    
    public boolean borrarCiudadano(BigDecimal id);
    
}
