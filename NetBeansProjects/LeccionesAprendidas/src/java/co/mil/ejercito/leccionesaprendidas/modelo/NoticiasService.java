/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.leccionesaprendidas.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class NoticiasService {

    private static final Logger LOG = Logger.getLogger(NoticiasService.class.getName());
    private FileHandler handler;

    public NoticiasService() {
        try {
            handler = new FileHandler("c:\\archivo.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOG.addHandler(handler);
        } catch (Exception ex) {

        }
    }
    
    
     public List<Noticia> consultarNoticias() {
        LOG.log(Level.INFO, "Entrada consultarNoticias()");
        List<Noticia> lista = new ArrayList();
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/getdeDS");
            Connection con = ds.getConnection();
            String SQL = "SELECT * FROM NOTICIAS";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                Noticia not = new Noticia();
                not.setId(rs.getInt(1));
                not.setDescripcion(rs.getString(2));
                not.setLink(rs.getString(3));
                lista.add(not);
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error consultarNoticias() " + e);
        }
        LOG.log(Level.INFO, "Salida consultarNoticias()");
        return lista;
    }
}
