

package co.mil.ejercito.rest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 *Fecha     Sep 11, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.mil.ejercito.rest.service.CountriesFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.DepartmentsFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.EmployeesFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.JobHistoryFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.JobsFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.LocationsFacadeREST.class);
        resources.add(co.mil.ejercito.rest.service.RegionsFacadeREST.class);
    }

}
