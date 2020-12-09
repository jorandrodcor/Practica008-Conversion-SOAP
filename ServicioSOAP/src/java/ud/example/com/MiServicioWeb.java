/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud.example.com;

import java.text.DecimalFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Host_W7U_SP1
 */
@WebService(serviceName = "MiServicioWeb")
public class MiServicioWeb {
    private double Euro;
    public MiServicioWeb(){
        Euro = 4230.01;
        
    }
        
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "GetEuro")
    public double getEuro(){
        return Euro;
    }
    
    @WebMethod(operationName = "Peso2Euro")
    public double Pero2Euro(@WebParam(name = "valor") String txt){
        double valorfinal = Math.round((Double.parseDouble(txt)/Euro)*100d)/100d;
        return valorfinal;
    }
            
    @WebMethod(operationName = "Euro2Peso")
    public double Euro2Peso(@WebParam(name = "valor") String txt){
        double valorfinal = Math.round((Double.parseDouble(txt)*Euro)*100d)/100d;
        return valorfinal;
    }
    
}// Cierre de la clase
