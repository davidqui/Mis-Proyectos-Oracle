/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.peliculas.facade;

import co.mil.ejercito.client.ConsumidorPeliculasService;
import co.mil.ejercito.consumer.GetdeConsumerRest;
import co.mil.ejercito.peliculas.entity.Categoria;
import co.mil.ejercito.peliculas.entity.Peliculas;
import co.mil.ejercito.peliculas.entity.Reservas;
import co.mil.ejercito.peliculas.entity.Usuarios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.String;

/**
 *
 * @author Administrator
 */
@Stateless
public class PeliculasFacade implements PeliculasFacadeLocal {

    private static final Logger LOG = Logger.getLogger(PeliculasFacade.class.getName());

    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "PeliculasPU")
    private EntityManager em;
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @Override

    public String consultarNombreCategoria(BigDecimal categoryID) {//SACAR EL NOMBRE DE UNA CATEGORIA
        LOG.log(Level.INFO, "Entrada al metodo consultarNombreCategoria ");
        String retorno = "";//NOMBRE DE LA CATEGORIA QUE QUIERO RETORNAR
        try {
            Categoria categoria = em.find(Categoria.class, categoryID);
            retorno = categoria.getCategoryName();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo consultarNombreCategoria ");
        return retorno;

    }

    @Override
    public List<Categoria> consultarCategorias() {
        LOG.log(Level.INFO, "Entrada al metodo consultarCategorias() ");
        List<Categoria> lista = new ArrayList();//NOMBRE DE LA CATEGORIA QUE QUIERO RETORNAR
        try {
            Query query = em.createNamedQuery("Categoria.findAll", Categoria.class);//toma el Query de la clase "Categoria"
            lista = query.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo consultarCategorias() ");
        return lista;
    }

    @Override
    public List<Peliculas> consultarPeliculas(String keyword) {
        LOG.log(Level.INFO, "Entrada al metodo consultarPeliculas() ");
        List<Peliculas> lista = new ArrayList();//NOMBRE DE LA CATEGORIA QUE QUIERO RETORNAR
        try {
            String SQL = "";//si esta en blanco lanza el *from"  y trae todas las peliculas
            if (keyword.equals("")) {
                SQL = "SELECT * FROM PELICULAS";

            } else {
                SQL = "select * from PELICULAS where titulo like '%"//DE LO CONTRARIO FILTRA POR "TITULO" O "PRECIO"
                        + keyword.trim() + "%'"
                        + " OR PRECIO LIKE '%" + keyword.trim() + "%'"; // "trim() " es para remover los espacios en blanco
            }

            Query query = em.createNativeQuery(SQL, Peliculas.class);
            lista = query.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo consultarPeliculas() ");
        return lista;
    }

    @Override
    public List<Peliculas> consultarPeliculasPorCategoria(BigDecimal categoryID) {
        LOG.log(Level.INFO, "Entrada al metodo consultarPeliculasPorCategoria ");
        List<Peliculas> lista = new ArrayList();
        try {
            Categoria categoria = em.find(Categoria.class, categoryID);
            lista = categoria.getPeliculasList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo consultarPeliculasPorCategoria ");
        return lista;
    }

    @Override
    public Peliculas consultarDetallesPeliculas(BigDecimal categoryID) {

        LOG.log(Level.INFO, "Entrada al metodo consultarDetallesPeliculas ");
        Peliculas pelicula = new Peliculas();//crea una pelicula vacia
        try {
            pelicula = em.find(Peliculas.class, categoryID);//el "entity" va y busca la pelicula por el ID

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo consultarDetallesPeliculas ");
        return pelicula;
    }

    @Override
    public long guardarReserva(Reservas reserva, BigDecimal idUsuario) {
        LOG.log(Level.INFO, "Entrada al metodo guardarReserva ");
        long resultado = 0L;
        try {
            Usuarios usuario = em.find(Usuarios.class, idUsuario);//el "entity" va y busca la pelicula por el ID
            reserva.setId(usuario);
            em.persist(reserva);
            resultado = System.currentTimeMillis();//generador del Tiket  "numero de milis desde 17

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%| este s el Consumidor SOAP|%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5
//            co.mil.ejercito.peliculas.ws.Reservas r = new co.mil.ejercito.peliculas.ws.Reservas();//del metodo del consumidor
//            r.setDescripcion(reserva.getDescripcion());
//            r.setFuncion(reserva.getFuncion());
//            r.setUbicacion(reserva.getUbicacion());            
//            resultado = ConsumidorPeliculasService.guardarReserva(r, idUsuario);//Uso del WS

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%| este s el Consumidor REST |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5

            String descripcion = reserva.getDescripcion();
            String funcion = reserva.getFuncion();
            String ubicacion = reserva.getUbicacion();
            String id = idUsuario.toString();            
            String resultadoRest  = GetdeConsumerRest.guardarReserva(descripcion, funcion, ubicacion,id);
            resultado = Long.parseLong(resultadoRest);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo guardarReserva ");
        return resultado;

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
