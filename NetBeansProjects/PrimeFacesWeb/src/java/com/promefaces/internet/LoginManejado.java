

package com.promefaces.internet;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 *Fecha     Aug 29, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@SessionScoped
@ManagedBean(name = "login")
public class LoginManejado implements Serializable{
    private String usuario;
    private String apellidos;
    private double salario;
    private String password;
    
    public String crearUsuario(){
        Usuario user = new Usuario();
        user.setNombre(getUsuario());
        user.setApellidos(getApellidos());
        user.setSalario(getSalario());
        user.setPassword(getPassword());
        UsuarioService service = new UsuarioService();
        service.crearUsuario(user);
        return "carrusel";
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
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
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
