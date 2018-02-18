

package com.promefaces.internet;

/**
 *
 *Fecha     Aug 29, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UsuarioService implements Serializable{

    private static final Logger LOG = Logger.getLogger(UsuarioService.class.getName());

    public void crearUsuario(Usuario usuario) {
        LOG.log(Level.INFO, "Entrada crearUsuario");
        
        try {
            Context ctx = new InitialContext();           //ESTO LO REMPLAZA EL "ds"
            DataSource ds = (DataSource) ctx.lookup("jdbc/oracle");
            Connection con = ds.getConnection();
            String SQL = "INSERT INTO USUARIO VALUES ('" +usuario.getNombre()
                    + "','" + usuario.getApellidos()+ "','" + usuario.getSalario()
                    + "'," + usuario.getPassword() + ")";
            Statement stm = con.createStatement();
            stm.executeQuery(SQL);
            stm.close();
            con.close();
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error critico " + e);
        }
        LOG.log(Level.INFO, "Salida consultarPeliculas");
        
    }

}
