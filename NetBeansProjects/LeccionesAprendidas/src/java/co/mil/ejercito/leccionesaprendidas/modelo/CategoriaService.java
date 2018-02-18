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
import java.util.function.Supplier;
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
public class CategoriaService {

    private static final Logger LOG = Logger.getLogger(CategoriaService.class.getName());

    private FileHandler handler;

    public CategoriaService() {
        try {
            handler = new FileHandler("c:\\archivo.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOG.addHandler(handler);
        } catch (Exception ex) {

        }
    }

    public List<Categoria> consultarCategorias() {
        LOG.log(Level.INFO, "Entrada consultarCategorias()");
        List<Categoria> lista = new ArrayList();
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/getdeDS");
            Connection con = ds.getConnection();
            con.setAutoCommit(false);//desconectar la "Commit" automatica
            String SQL = "SELECT CATEGORY_ID,CATEGORY_NAME FROM CATEGORIA";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt(1));
                cat.setNombre(rs.getString(2));
                lista.add(cat);
            }
            con.commit();// termina el "Commit"
            //con.rollback();//devuelve los cambios sin confirmar
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error consultarCategorias() " + e);
        }
        LOG.log(Level.INFO, "Salida consultarCategorias()");
        return lista;
    }

}
