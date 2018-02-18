package co.mil.ejercito.getde;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * Fecha Sep 28, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class GetdeLaboratorio {
    public static void main(String[] args) throws Exception{
        ejecutarJava();
    }

    /**
     * PARA LLAMAR EL PROCEDURE
     *
     * @throws Exception
     */
    public static void ejecutarProcedure() throws Exception {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection con
                = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                        "PELICULAS", "ORACLE");
        CallableStatement call = con.prepareCall("{call PELICULASINSERT()}");
        //PARA MEDIR EL TIEMPO QUE TARDA EN LA EJECUCION
        long tiempoInicial = System.currentTimeMillis();
        call.execute();//ejecuta el "Procedure" en la DBA
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("TIEMPO TOTAL " + (tiempoFinal - tiempoInicial));
        //System.exit(0);       //para Tumbar el servidor de aplicaciones (cierra todo progama JAVA)
    }

    /**
     * PARA QUE JAVA HAGA EL INSERTE
     *
     * @throws Exception
     */
    public static void ejecutarJava() throws Exception {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection con
                = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                        "PELICULAS", "ORACLE");
        String SQL = "INSERT INTO PELICULAS values (PELICULAS_SEQ.NEXTVAL,"
                + "1, 'Pelicula','Pelicula',7000)";
        Statement stm = con.createStatement();
        long tiempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            stm.executeUpdate(SQL);

        }
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("TIEMPO TOTAL " + (tiempoFinal - tiempoInicial) + " ms");

    }

}
