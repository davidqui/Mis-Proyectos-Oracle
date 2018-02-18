/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.modelo;

//import co.mil.ejercito.web.LoginService;
import co.mil.ejercito.web.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Administrator
 */
@Stateless
//EN LOS "EJB" SE LE ADICIONA ESTE RENGLON PARA ESPECIFICAR QUE LAS TRANSACCIONES VA A SER MANEJADOS MANUALMENTE
@TransactionManagement(TransactionManagementType.BEAN)
public class LoginFacade implements LoginFacadeLocal {

    private static final Logger LOG = Logger.getLogger(LoginFacade.class.getName());
    //le insertamos el UserTransaction para controlar las transacciones en EJB 
    @Resource
    UserTransaction utx;

    @Override
    public Usuario validarUsuario(String user, String password) {

        LOG.log(Level.INFO, "Entrada validarUsuario");
        
        Usuario usuario = new Usuario();
        try {
            utx.begin();//inicia  el "Comic"

            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/oracle");
            Connection con = ds.getConnection();
            String SQL = "SELECT * FROM LOGIN WHERE NOMBRE='" + user + "' AND PASSWORD='" + password + "'";
            Statement stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                usuario.setUsuario(rs.getString(1));
                usuario.setPassword(rs.getString(2));
            }
           
            rs.close();
            con.close();
             utx.commit();//cierra el comic
            //utx.rollback();

        } catch (Exception e) {
            try {
                utx.rollback();//para devolver los cambios que no han sido confirmados
            } catch (IllegalStateException ex) {
                Logger.getLogger(LoginFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(LoginFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(LoginFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
            LOG.log(Level.SEVERE, "Error " + e);
        }

        LOG.log(Level.INFO, "Salida validarUsuario");
        return usuario;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
