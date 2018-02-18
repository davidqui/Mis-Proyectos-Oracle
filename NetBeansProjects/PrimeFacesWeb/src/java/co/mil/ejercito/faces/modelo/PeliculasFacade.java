/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.faces.modelo;

import com.promefaces.internet.Pelicula;
import co.mil.ejercito.faces.inge.reviw.Peliculas;
//import co.mil.ejercito.faces.PeliculaService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@Stateless
public class PeliculasFacade implements PeliculasFacadeLocal {

   private static final Logger LOG = Logger.getLogger(PeliculasFacade.class.getName());

//    @Resource(name = "jdbc/oracle", lookup = "jdbc/oracle")
//    private DataSource ds;
   EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("PrimeFacesWebPU");
        EntityManager em = emf.createEntityManager();
    
   @Override
   public List<Peliculas> consultarPeliculas(){
       Query query = em.createNativeQuery("SELECT * FROM PELICULA");
       List<Peliculas> pelis = query.getResultList();
       return pelis;
       
   }
    
   //@Override
    public List<Pelicula> consultarPeliculas2() {
        LOG.log(Level.INFO, "Entrada consultarPeliculas");
        List<Pelicula> lista = new ArrayList();
        try {
            Context ctx = new InitialContext();           //ESTO LO REMPLAZA EL "ds"
            DataSource ds = (DataSource) ctx.lookup("jdbc/oracle");
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
                pelicula.setVisita(rs.getInt(6));
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
