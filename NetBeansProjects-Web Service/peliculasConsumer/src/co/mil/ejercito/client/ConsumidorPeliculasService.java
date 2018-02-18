package co.mil.ejercito.client;

import java.math.BigDecimal;

/**
 *
 * Fecha Sep 20, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class ConsumidorPeliculasService {
    public static void main(String[] args) throws Exception{
        
     co.mil.ejercito.peliculas.ws.Reservas reserva = new co.mil.ejercito.peliculas.ws.Reservas();
     reserva.setDescripcion("DESCRIPCION");
     reserva.setFuncion("7:30");
     reserva.setUbicacion("10H");
     
     long resultado = guardarReserva(reserva,new BigDecimal("1"));
        System.out.println(resultado);
    }

    public static long guardarReserva(co.mil.ejercito.peliculas.ws.Reservas reserva, java.math.BigDecimal idUsuario) {
        co.mil.ejercito.peliculas.ws.PeliculasService_Service service = new co.mil.ejercito.peliculas.ws.PeliculasService_Service();
        co.mil.ejercito.peliculas.ws.PeliculasService port = service.getPeliculasServicePort();
        return port.guardarReserva(reserva, idUsuario);
    }

    

}
