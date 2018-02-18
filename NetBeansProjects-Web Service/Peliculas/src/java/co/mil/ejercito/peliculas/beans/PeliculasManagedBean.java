package co.mil.ejercito.peliculas.beans;

import co.mil.ejercito.peliculas.entity.Categoria;
import co.mil.ejercito.peliculas.entity.Peliculas;
import co.mil.ejercito.peliculas.entity.Reservas;
import co.mil.ejercito.peliculas.facade.PeliculasFacadeLocal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.model.ListDataModel;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * Fecha Sep 20, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@ManagedBean(name = "peliculasBean")
@SessionScoped      // para que quede global en la Session
public class PeliculasManagedBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(PeliculasManagedBean.class.getName());
    
//    @PersistenceContext(unitName = "PeliculasPU")
//    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;

    //importamos El EJB de la interfaz local------------
    @EJB                                // ESTE ES EL ENLACE ENTRE EL (BEAN) Y LA (FACADE)
    private PeliculasFacadeLocal ejb;
    //---------------------------------------------------

    private List<Peliculas> peliculas; // esta line es la que pinta la tabla de Peliculas
    private HtmlInputText searchTxt = new HtmlInputText();// la caja de texto para buscar 
    private String idCategoria;
    private String nombreCategoria;
    private Peliculas pelicula;
    private String principal;
    private Reservas reserva = new Reservas();
    private long codigoReserva;
    private String archivo;
    
    private ListDataModel PeliculasDataModel = new ListDataModel();//PARA ENLAZAR AUTOMATICAMENTE LA TABLA IZQUIERDA
    private ListDataModel categoriasDataModel = new ListDataModel();//PARA ENLAZAR AUTOMATICAMENTE LA TABLA IZQUIERDA
    
    public  String checkOut(){
        LOG.log(Level.INFO, " Entrada al metodo checkOut()");
        try {
            codigoReserva = ejb.guardarReserva(reserva, new BigDecimal("1"));
            reserva.setDescripcion("");
            reserva.setFuncion("");
            reserva.setUbicacion("");
            archivo = "" + codigoReserva + ".png";//el mismo nombre del archivo --del mismo nombre del archivo
            
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, " Error ", e);
        }
        LOG.log(Level.INFO, " Salida del  metodo scheckOut()");
        return "confirmacionReserva";
    }

    public long getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(long codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
    
    
    public String registrarReserva(){
        Principal principal = FacesContext.getCurrentInstance()
                .getExternalContext().getUserPrincipal();
        setPrincipal(principal.getName());
        return "registrarReserva";
    }
    
    public String seleccionarPelicula() {
        LOG.log(Level.INFO, " Entrada al metodo seleccionarPelicula()");
        try {
            pelicula = (Peliculas) PeliculasDataModel.getRowData();//para que seleccione automaticamente
        } catch (Exception e) {
            LOG.log(Level.SEVERE, " Error ", e);
        }
        LOG.log(Level.INFO, " Salida del  metodo seleccionarPelicula()");
        return "detallePelicula";//retorna el "xhtml"
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }
    

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
    

    public ListDataModel getPeliculasDataModel() {
        return PeliculasDataModel;
    }

    public void setPeliculasDataModel(ListDataModel PeliculasDataModel) {
        this.PeliculasDataModel = PeliculasDataModel;
    }
    

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ListDataModel getCategorias() {
        LOG.log(Level.INFO, " Entrada al metodo getCategorias()");
        try {
            categoriasDataModel.setWrappedData(ejb.consultarCategorias());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, " Error ", e);
        }
        LOG.log(Level.INFO, " Salida del  metodo getCategorias()");
        return categoriasDataModel;
    }

    public String seleccionarCategoria() {
        LOG.log(Level.INFO, " Entrada al metodo seleccionarCategoria()");
        try {
            Categoria categoria = (Categoria) categoriasDataModel.getRowData();//trae la categoria filtrado automaticamente
            idCategoria = String.valueOf(categoria.getCategoryId());
            nombreCategoria = categoria.getCategoryName();
            peliculas = ejb.consultarPeliculasPorCategoria(new BigDecimal(idCategoria));// este es el enlace de la "fachada" con el "BeanManejado"

        } catch (Exception e) {
            LOG.log(Level.SEVERE, " Error ", e);
        }
        LOG.log(Level.INFO, " Entrada al metodo seleccionarCategoria()");
        return "listaPeliculas";

    }

    public String buscarPeliculas() {
        LOG.log(Level.INFO, " Entrada al metodo buscarPeliculas()");
        try {
            String searchKeyword = (String) searchTxt.getSubmittedValue();
            peliculas = ejb.consultarPeliculas(searchKeyword);
            searchTxt.setValue("");// para que le deje en blanco la caja de texto despues de la busqueda
        } catch (Exception e) {
            LOG.log(Level.SEVERE, " Error ", e);
        }
        LOG.log(Level.INFO, " Salida del  metodo buscarPeliculas()");

        return "listaPeliculas";// llama el "xhtml" (listaPeliculas.xhtml)
    }

    /**
     * @return the searchTxt
     */
    public HtmlInputText getSearchTxt() {
        return searchTxt;
    }

    /**
     * @param searchTxt the searchTxt to set
     */
    public void setSearchTxt(HtmlInputText searchTxt) {
        this.searchTxt = searchTxt;
    }

    /**
     * @return the peliculas
     */
    public ListDataModel getPeliculas() {
        PeliculasDataModel.setWrappedData(peliculas);//llena el DataModel con las peliculas consultadas
        return PeliculasDataModel;
    }

    /**
     * @param peliculas the peliculas to set
     */
    public void setPeliculas(List<Peliculas> peliculas) {
        this.peliculas = peliculas;
    }
    
    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        } else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String filename = 
                    context.getExternalContext().
                            getRequestParameterMap().get("filename");//parametriza el archivo
            return new DefaultStreamedContent(
                    new FileInputStream(new File("c:/", filename)));
        }
    }

//    public void persist(Object object) {
//        try {
//            utx.begin();
//            em.persist(object);
//            utx.commit();
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }

}
