/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hosting.modelo;

import co.mil.ejercito.hosting.entity.Contact;
import co.mil.ejercito.hosting.entity.DomainFtpFeatures;
import co.mil.ejercito.hosting.entity.EmailFeatures;
import co.mil.ejercito.hosting.entity.ShareHostingPlan;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author oracle
 */
@Stateless
public class HostingFacade implements HostingFacadeLocal {

    private static final Logger LOG = Logger.getLogger(HostingFacade.class.getName());

    @PersistenceContext(name = "WebHostingPU")
    private EntityManager em;

    @Override
    public List<ShareHostingPlan> consultarShareHostingPlan() {
        LOG.log(Level.INFO, "Entrada consultarShareHostingPlan");
        List<ShareHostingPlan> lista = new ArrayList();
        try {
            Query query = em.createNativeQuery("SELECT * FROM  SHARE_HOSTING_PLAN", ShareHostingPlan.class);
            lista = query.getResultList();
        }catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  EN EL HOSTING" + e);
        } 
 
        LOG.log(Level.INFO, "Salida consultarShareHostingPlan");
        return lista;
    }

    @Override
    public List<DomainFtpFeatures> consultarDomainFtpFeatures() {
        LOG.log(Level.INFO, "Entrada consultarDomainFtpFeatures");
        List<DomainFtpFeatures> lista = new ArrayList();
        //TODO: SE ME OLVIDO PROGRAMAR LO SIENTO MUCHO :( 
        try {
            Query query = em.createNativeQuery("SELECT * FROM  DOMAIN_FTP_FEATURES", DomainFtpFeatures.class);
            lista = query.getResultList();
        }catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  EN DOMAIN" + e);
        } 

        
        LOG.log(Level.INFO, "Salida consultarDomainFtpFeatures");
        return lista;
    }

    @Override
    public List<EmailFeatures> consultarEmailFeatures() {
        LOG.log(Level.INFO, "Entrada consultarEmailFeatures");
        List<EmailFeatures> lista = new ArrayList();
        //TODO: COMO QUE TAMPOCO ESTA EL CODIGO DE CONSULTA PARA ESTE METODO :)
        try {
            Query query = em.createNativeQuery("SELECT * FROM  EMAIL_FEATURES", EmailFeatures.class);
            lista = query.getResultList();
        }catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  EN EMAIL" + e);
        }
        
        LOG.log(Level.INFO, "Salida consultarEmailFeatures");
        return lista;
    }
    
//    @Resource(name = "jdbc/hosting",lookup = "jdbc/hosting")
//    private DataSource ds;

    @Override
    public boolean enviarInformacionContacto(String name, String email, String subjetc, String message) {
        boolean retorno = false;
        LOG.log(Level.INFO, "Entrada enviarInformacionContacto");

        try {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setEmail(email);
            contact.setSubject(subjetc);
            contact.setMessage(message);
            //contact.setId(BigDecimal.ONE);//pendiente
            // ESTO VA POR TODAS LAS TRASNOCHADAS QUE ME HICIERON PASAR. :) :) :)
            em.persist(contact);
             
            retorno = true;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error   FINAL" + e);
        }

        LOG.log(Level.INFO, "Salida enviarInformacionContacto");
        return retorno;
    }

}
