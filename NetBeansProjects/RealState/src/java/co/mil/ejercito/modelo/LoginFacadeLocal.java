/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.modelo;

import co.mil.ejercito.web.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface LoginFacadeLocal {
    
    public Usuario validarUsuario(String user, String password);//metodo astractos "solo se declaran
    
}
