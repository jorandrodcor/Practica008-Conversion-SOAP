package Clases;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

public class WebServices {

    private static String NAMESPACE = "http://com.example.ud/";
    //private static String URL ="http://70c06cad341f.ngrok.io/ServidorSOAP1/MiServicioWeb?WSDL";
    //private static String URL ="http://euroconvert.azurewebsites.net/WebService1.asmx";
    private static String URL ="http://192.168.0.3:8080/ServicioSOAP/MiServicioWeb?WSDL";
    private static String SOAP_ACTION = "http://com.example.ud/";

    public static double CapturaEurosWS(String webMathName){
        double resTXT = 0;
        SoapObject request = new SoapObject(NAMESPACE, webMathName);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try{
            androidHttpTransport.call(SOAP_ACTION+webMathName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            resTXT = Double.parseDouble(response.toString());
        }
        catch(Exception Ex){
            Ex.printStackTrace();
        }
        return resTXT;
    }//CapturaEurosWS

    public static double CambioEurosWS(String webMathName, String valord){
        double resTXT = 0;
        SoapObject request = new SoapObject(NAMESPACE, webMathName);
        request.addProperty("valor", valord);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try{
            androidHttpTransport.call(SOAP_ACTION+webMathName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            resTXT = Double.parseDouble(response.toString());
        }
        catch(Exception Ex){
            Ex.printStackTrace();
        }
        return resTXT;
    }//CambioEurosWS

    public static String HolaMundoWS(String name, String webMethName){
        String resTxt = null;
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        request.addProperty("name", name);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try{
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            resTxt = response.toString();
        }
        catch(Exception e){
            e.printStackTrace();
            resTxt = e.getMessage();
        }
        return resTxt;
    }//HolaMundoWS


}
