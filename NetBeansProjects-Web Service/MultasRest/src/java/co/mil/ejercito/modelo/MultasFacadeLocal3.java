/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.modelo;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface MultasFacadeLocal3 {

    public boolean crearCiudadano(String nombre, String apellido, String email, String telefono);

    public boolean borrarCiudadano(String id);
}
