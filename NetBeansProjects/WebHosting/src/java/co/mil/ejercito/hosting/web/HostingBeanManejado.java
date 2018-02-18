/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hosting.web;

import co.mil.ejercito.hosting.entity.Contact;
import co.mil.ejercito.hosting.entity.DomainFtpFeatures;
import co.mil.ejercito.hosting.entity.EmailFeatures;
import co.mil.ejercito.hosting.entity.ShareHostingPlan;
import co.mil.ejercito.hosting.modelo.HostingFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author oracle
 */
@ManagedBean(name = "hosting")
@SessionScoped
public class HostingBeanManejado {

    private static final Logger LOG = Logger.getLogger(HostingBeanManejado.class.getName());

    private List<ShareHostingPlan> listaHosting;
    private List<DomainFtpFeatures> listaDomainFtpFeatures;
    private List<EmailFeatures> listaEmailFeatures;
    private String author;
    private String email;
    private String subject;
    private String text;

    @EJB
    private HostingFacadeLocal ejb;

    public String enviarContacto() {

        LOG.log(Level.INFO, "Entrada enviarContacto");

        if (validarCamposFormulario()) {
            try {
                ejb.enviarInformacionContacto(author, email, subject, text);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La informacion fue enviada"));

            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Error " + e);
            }
        } else {

        }
        LOG.log(Level.INFO, "Salida enviarContacto");
        return "contact";

    }

    public boolean validarCamposFormulario() {
        // SERA QUE SE PERDIERON ALGUNAS VALIDACIONES?? YO DIRIA QUE SI
        boolean retorno = true;
        if (author.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El nombre es campo requerido"));
            retorno = false;
        }
        if (email.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El Email es campo requerido"));
            retorno = false;
        }
        if (subject.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Subjec es Campo Requerido"));
            retorno = false;
        }
        if (text.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Mensaje es Campo Requerido"));
            retorno = false;
        }

      
        return retorno;
    }

    /**
     * @return the listaHosting
     */
    public List<ShareHostingPlan> getListaHosting() {
        LOG.log(Level.INFO, "Entrada getListaHosting");

        try {
            listaHosting = ejb.consultarShareHostingPlan();

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
        }
        LOG.log(Level.INFO, "Salida getListaHosting");
        return listaHosting;
    }

    /**
     * @param listaHosting the listaHosting to set
     */
    public void setListaHosting(List<ShareHostingPlan> listaHosting) {
        this.listaHosting = listaHosting;
    }

    /**
     * @return the listaDomainFtpFeatures
     */
    public List<DomainFtpFeatures> getListaDomainFtpFeatures() {

        LOG.log(Level.INFO, "Entrada getListaDomainFtpFeatures");
        try {
            listaDomainFtpFeatures = ejb.consultarDomainFtpFeatures();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
        }
        LOG.log(Level.INFO, "Salida getListaDomainFtpFeatures");

        return listaDomainFtpFeatures;
    }

    /**
     * @param listaDomainFtpFeatures the listaDomainFtpFeatures to set
     */
    public void setListaDomainFtpFeatures(List<DomainFtpFeatures> listaDomainFtpFeatures) {
        this.listaDomainFtpFeatures = listaDomainFtpFeatures;
    }

    /**
     * @return the listaEmailFeatures
     */
    public List<EmailFeatures> getListaEmailFeatures() {
        LOG.log(Level.INFO, "Entrada getListaDomainFtpFeatures");
        try {
            listaEmailFeatures = ejb.consultarEmailFeatures();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
        }
        LOG.log(Level.INFO, "Salida getListaDomainFtpFeatures");

        return listaEmailFeatures;
    }

    /**
     * @param listaEmailFeatures the listaEmailFeatures to set
     */
    public void setListaEmailFeatures(List<EmailFeatures> listaEmailFeatures) {
        this.listaEmailFeatures = listaEmailFeatures;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
