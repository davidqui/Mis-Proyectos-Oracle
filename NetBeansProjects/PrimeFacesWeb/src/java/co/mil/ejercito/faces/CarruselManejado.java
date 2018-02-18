
package co.mil.ejercito.faces;

import co.mil.ejercito.faces.inge.reviw.Peliculas;
import co.mil.ejercito.faces.modelo.PeliculasFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "carrusel")
@SessionScoped
public class CarruselManejado implements Serializable {

    private List<Peliculas> listaPeliculas;
    
    @EJB
    private PeliculasFacadeLocal ejb;

    /**
     * @return the listaPeliculas
     */
    public List<Peliculas> getListaPeliculas() {
        //PeliculaService service = new PeliculaService();
        
        return ejb.consultarPeliculas();
    }

    /**
     * @param listaPeliculas the listaPeliculas to set
     */
    public void setListaPeliculas(List<Peliculas> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

}
