
package co.mil.ejercito.peliculas.facade;

import co.mil.ejercito.peliculas.entity.Categoria;
import co.mil.ejercito.peliculas.entity.Peliculas;
import co.mil.ejercito.peliculas.entity.Reservas;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface PeliculasFacadeLocal {
    public String consultarNombreCategoria(BigDecimal categoryID);
    
    public List<Categoria> consultarCategorias();
    
    public List<Peliculas> consultarPeliculas(String keyword);
    
    public List<Peliculas> consultarPeliculasPorCategoria(BigDecimal categoryID);
    
    public Peliculas consultarDetallesPeliculas(BigDecimal categoryID);
    
    public long guardarReserva(Reservas reserva, BigDecimal idUsuario);

    
    
}
