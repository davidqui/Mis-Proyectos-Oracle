package co.mil.ejercito.web;

import co.mil.ejercito.modelo.LoginFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String password;
    @EJB
    private LoginFacadeLocal ejb;

    public String autenticarUsuario() {
        String retorno = "list";
        if (usuario.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Usuario es Campo Requerido"));
            retorno = "login";
        }
        if (password.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Password es Campo Requerido"));
            retorno = "login";
        }

        if (!usuario.equals("") && !password.equals("")) {
            //LoginService service = new LoginService();
            Usuario user = ejb.validarUsuario(usuario, password);
            if (user.getUsuario().equals("") && user.getPassword().equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Usuario o contraseña incorrectos"));
                retorno = "login";
            }
        }
        return retorno;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
