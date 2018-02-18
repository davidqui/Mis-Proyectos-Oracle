/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.aplicacion.facade;

import co.mil.ejercito.aplicacion.entity.DescripcionViviendas;
import co.mil.ejercito.aplicacion.entity.DetalleViviendas;
import co.mil.ejercito.aplicacion.entity.InformacionEmpresa;
import co.mil.ejercito.aplicacion.entity.TipoContratos;
import co.mil.ejercito.aplicacion.entity.Usuarios;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class RealStateFacade implements RealStateFacadeLocal {

    private static final Logger LOG = Logger.getLogger(RealStateFacade.class.getName());

    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "RealStatePU")
    private EntityManager em;
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @Override
    public List<DescripcionViviendas> findYourPlace(String keyword) {
        LOG.log(Level.INFO, "Entrada al metodo findYourPlace() ");
        List<DescripcionViviendas> lista = new ArrayList();
        try {
            String SQL = " ";//si esta en blanco lanza el *from"  y trae todas las peliculas
            if (keyword.equals("")) {
                SQL = "SELECT * FROM DESCRIPCION_VIVIENDAS";

            } else {
                SQL = "select * from DESCRIPCION_VIVIENDAS where CANT_HABITACIONES like '%"//DE LO CONTRARIO FILTRA POR "TITULO" O "PRECIO"
                        + keyword.trim() + "%'"
                        + " or PRECIO like '%" + keyword.trim() + "%'"; // "trim() " es para remover los espacios en blanco
            }

            Query query = em.createNativeQuery(SQL, DescripcionViviendas.class);
            lista = query.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo findYourPlace() ");
        return lista;
    }

    @Override
    public String joinOurNewsletter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InformacionEmpresa informacionEmpresa(String nit) {
        LOG.log(Level.INFO, "Entrada al metodo informacionEmpresa() ");
        InformacionEmpresa infEmpresa = new InformacionEmpresa();//crea una pelicula vacia
        try {
//            infEmpresa = em.find(InformacionEmpresa.class, nit);//el "entity" va y busca la pelicula por el ID
//           Query query = em.createNamedQuery("InformacionEmpresa.findAll",InformacionEmpresa.class);//toma el Query de la clase "Categoria"
//           infEmpresa = query.getResultList();
//            infEmpresa.getNit();
//            infEmpresa.getDireEmp();
//            infEmpresa.getTelEmp();
//            infEmpresa.getCelular();
//            infEmpresa.getEmal();
//            infEmpresa.getFax();
//            infEmpresa.getUrl();
//            infEmpresa.getAbout();
//            infEmpresa.getRequest();
            
            String SQL = " select * from informacion_empresa";
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo informacionEmpresa() ");

        return infEmpresa;
    }

    @Override
    public Random specialOffers(BigDecimal idDescrVivienda) {
        Random r = new Random();
        LOG.log(Level.INFO, "Entrada al metodo specialOffers() ");
        try {
            DetalleViviendas dtvivienda = em.find(DetalleViviendas.class, idDescrVivienda);
            r = (Random) dtvivienda.getConsultaViviendasList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo cspecialOffers() ");
        return r;
    }

    @Override
    public boolean tipoContrato(BigDecimal idContrato) {
        LOG.log(Level.INFO, "Entrada al metodo tipoContrato() ");
        try {
            TipoContratos tc = new TipoContratos();
            tc.setIdContrato(idContrato);
            tc.setDescriC("");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo tipoContrato() ");
        return true;

    }

//    @Override
//    public String enviarContacto(Usuarios usuario, BigInteger idUser) {
//        LOG.log(Level.INFO, "Entrada al metodo enviarContacto ");
//        String resultado = "";
//        try {
//            Usuarios user = em.find(Usuarios.class, idUser);//el "entity" va y busca la pelicula por el ID
//            usuario.setUsuariosPK(idUser);
//            em.persist(usuario);
//            resultado = user.getCorreoU();//generador del Tiket  "numero de milis desde 17
//
//            co.mil.ejercito.peliculas.ws.Reservas r = new co.mil.ejercito.peliculas.ws.Reservas();//del metodo del consumidor
//            r.setDescripcion(reserva.getDescripcion());
//            r.setFuncion(reserva.getFuncion());
//            r.setUbicacion(reserva.getUbicacion());
//            resultado = ConsumidorPeliculasService.guardarReserva(r, idUsuario);//Uso del WS
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "Error  ", e);
//        }
//        LOG.log(Level.INFO, "Salida del metodo guardarReserva ");
//        return resultado;
//    }
//        
    @Override
    public String enviarContacto(Usuarios usuario, BigInteger idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
