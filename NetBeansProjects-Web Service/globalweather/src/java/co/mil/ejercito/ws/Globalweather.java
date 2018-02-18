

package co.mil.ejercito.ws;

import javax.jws.WebService;

/**
 *
 *Fecha     Sep 12, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@WebService(serviceName = "GlobalWeather", portName = "GlobalWeatherSoap", endpointInterface = "net.webservicex.GlobalWeatherSoap", targetNamespace = "http://www.webserviceX.NET", wsdlLocation = "WEB-INF/wsdl/Globalweather/globalweather.asmx.wsdl")
public class Globalweather {

    public java.lang.String getWeather(java.lang.String cityName, java.lang.String countryName) {
        //TODO implement this method
        return cityName + countryName;
    }

    public java.lang.String getCitiesByCountry(java.lang.String countryName) {
        //TODO implement this method
        return countryName;
    }

}
