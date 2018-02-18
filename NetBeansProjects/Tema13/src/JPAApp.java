import co.mil.ejercito.jpa.Countries;
import co.mil.ejercito.jpa.Departments;
import co.mil.ejercito.jpa.Employees;
import co.mil.ejercito.jpa.Locations;
import co.mil.ejercito.jpa.Regions;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * Fecha Aug 31, 2017
 *
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class JPAApp {

    public static void main(String[] args) {
        //conectar la persistencia  
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Tema13PU");
        EntityManager em = emf.createEntityManager();

        //select para traer el nombre del empleado del departamento 10
        Departments dep = em.find(Departments.class, Short.parseShort("10"));
        List<Employees> emps = dep.getEmployeesList();
        for (Employees e : emps) {
            System.out.println(e.getFirstName());

        }
        //nombra un contador para que nos muestre la cantidad de empleados
        int i = 0;
        Regions reg = em.find(Regions.class, new BigDecimal("2"));
        List<Countries> c = reg.getCountriesList();//la Lista conecta con la siguinte tabla
        for (Countries co : c) {
            List<Locations> loc = co.getLocationsList();//
            for (Locations l : loc) {
                List<Departments> deps = l.getDepartmentsList();//Class Departments
                for (Departments d : deps) {
                    List<Employees> emp = d.getEmployeesList();//Class Employees
                    for (Employees e : emp) {
                        System.out.println(e.getFirstName());
                        i++;

                    }

                }

            }

        }
        System.out.println("Numero total de registros es = " + i);

    }

}
