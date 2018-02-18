/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "bean")
@SessionScoped
public class BeanManejado implements Serializable{
 
    private String usuario;
    private String password;
    
   
    
    public List<String> completar() {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add("" + i);
        }
         
        return results;
    }

    
    public String procesarPassword(){
        System.out.println(usuario);
        System.out.println(password);
        return "lista";
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
