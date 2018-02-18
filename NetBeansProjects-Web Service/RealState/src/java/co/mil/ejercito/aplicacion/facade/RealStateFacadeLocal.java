/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.aplicacion.facade;

import co.mil.ejercito.aplicacion.entity.DescripcionViviendas;
import co.mil.ejercito.aplicacion.entity.InformacionEmpresa;
import co.mil.ejercito.aplicacion.entity.Usuarios;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface RealStateFacadeLocal {
    
    public List<DescripcionViviendas> findYourPlace(String keyword);
    public String joinOurNewsletter();
    public InformacionEmpresa informacionEmpresa(String nit);
    public boolean tipoContrato(BigDecimal idContrato);
    public String enviarContacto(Usuarios usuario, BigInteger idUser);
    public Random  specialOffers(BigDecimal idDescrVivienda);
    
    
    
    
    
    //public String consultarViviendaPorEstado(BigDecimal idConsult);
     //public String aboutUs();
    
    
   
    
    
    
}
