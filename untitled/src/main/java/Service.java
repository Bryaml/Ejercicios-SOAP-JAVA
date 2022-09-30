import javax.xml.ws.Endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Random;

@WebService(name="Service", targetNamespace="Utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Service {

    @WebMethod(operationName ="responseMessage")
    public  String responseMessage(@WebParam(name ="message")String str) {


        return "el resultado es:  " + str ;
    }
    @WebMethod(operationName ="responseMessage2")
    public  String responseMessage2(@WebParam(name ="message")String rfc) {



        return "rfc es:  " + rfc ;
    }

    public static void main(String[] args) {
        System.out.println("Initializing server...");
        Endpoint.publish("http://localhost:8081/service",new Service());
        System.out.println("Watting requets..");
    }

}
