/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "dao")
@SessionScoped
public class PeliculaService {

    private static final Logger LOG = Logger.getLogger(PeliculaService.class.getName());
    @Resource(name = "jdbc/oracle",lookup = "jdbc/oracle")
    private DataSource ds;

    public List<Pelicula> consultarPeliculas() {
        LOG.log(Level.INFO, "Entrada consultarPeliculas");
        List<Pelicula> lista = new ArrayList();
        try {
            //ds = (DataSource) ctx.lookup("jdbc/oracle");
            Connection con = ds.getConnection();
            String SQL = "SELECT * FROM PELICULA";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setAno(rs.getString(3));
                pelicula.setGenero(rs.getString(4));
                pelicula.setImagen(rs.getString(5));               
                lista.add(pelicula);
            }
            rs.close();
            stm.close();
            con.close();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
        }
        LOG.log(Level.INFO, "Salida consultarPeliculas");
        return lista;
    }

}
