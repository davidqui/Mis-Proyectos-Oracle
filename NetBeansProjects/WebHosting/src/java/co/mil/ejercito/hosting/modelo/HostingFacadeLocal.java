/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hosting.modelo;

import co.mil.ejercito.hosting.entity.DomainFtpFeatures;
import co.mil.ejercito.hosting.entity.EmailFeatures;
import co.mil.ejercito.hosting.entity.ShareHostingPlan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author oracle
 */
@Local
public interface HostingFacadeLocal {

    public List<ShareHostingPlan> consultarShareHostingPlan();

    public List<DomainFtpFeatures> consultarDomainFtpFeatures();

    public List<EmailFeatures> consultarEmailFeatures();
    
    public boolean enviarInformacionContacto(String name, String email, String subjetc, String message);

}
