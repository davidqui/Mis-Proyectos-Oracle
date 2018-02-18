/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.model;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "pelicula")
@SessionScoped
public class PeliculaBean {

    private List<Pelicula> listaPeliculas;
    @ManagedProperty(value = "#{dao}")
    private PeliculaService dao;
  
   

    /**
     * @return the listaPeliculas
     */
    public List<Pelicula> getListaPeliculas() {

        listaPeliculas = getDao().consultarPeliculas();
        return listaPeliculas;
    }

    /**
     * @param listaPeliculas the listaPeliculas to set
     */
    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    /**
     * @return the dao
     */
    public PeliculaService getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(PeliculaService dao) {
        this.dao = dao;
    }

    

}
