/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.faces.modelo;

import co.mil.ejercito.faces.inge.reviw.Peliculas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface PeliculasFacadeLocal {
    
    public List<Peliculas> consultarPeliculas();
    
}
