/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Administrator
 */
@ManagedBean(name = "pie")
@SessionScoped
public class PieService implements Serializable {

    private PieChartModel datos = new PieChartModel();

    {
        datos.set("Serie 1", 540);
        datos.set("Serie 2", 325);
        datos.set("Serie 3", 702);
        datos.set("Serie 4", 421);
        datos.setTitle("Simple Pie");
        datos.setLegendPosition("w");
        datos.setDiameter(150);
        datos.setShowDataLabels(true);
    }

    /**
     * @return the datos
     */
    public PieChartModel getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(PieChartModel datos) {
        this.datos = datos;
    }

}
