/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.modelo;

import java.math.BigDecimal;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface MultasFacadeLocal {
    public boolean crearCiudadano(String nombre, String apellido, 
            String email, String telefono);
    
    public boolean borrarCiudadano(BigDecimal id);
}
