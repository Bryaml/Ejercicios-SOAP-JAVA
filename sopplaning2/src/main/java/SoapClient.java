import utez.ServiceService;
import utez.Service;

import java.util.Random;
import java.util.Scanner;


public class SoapClient {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ServiceService service = new ServiceService();
        Service port = (Service) service.getServicePort();
        int opc;
        do {
            System.out.println("1 numeros alatorios");
            System.out.println("2 Elimina vocales");
            System.out.println("3 sacar rfc");
            System.out.println("4 salir");

            opc = input.nextInt();
            switch (opc) {
                case 1:


                    int a = (int) ((Math.random() * 5)+1);
                    int b;
                    int i;

                    System.out.println("El juego consiste en adivinar un numero a la azar de 1 a 5");

                    System.out.print("adivina el numero  ");
                    b = input.nextInt();

                    for (i=0; i<=4; i++) {


                        if (a == b) {
                            System.out.println( port.responseMessage("has acertado") );
                            break;
                        } else if (i == 4) {
                            System.out.println("Lo siento: ¡has perdido!. El número era el: " + a);
                            break;
                        } else if (a > b)
                            System.out.println("El número secreto es MAYOR que " + b);
                        else if (a < b)
                            System.out.println("El número secreto es MENOR que " + b);


                        if (i <= 1) {
                            System.out.print("Otro intento: " );
                            b = input.nextInt();
                        } else if (i == 2) {
                            int x = (int) (a / 10);
                            System.out.println("Una pista, la primera cifra es " + x);
                            System.out.print("Inténtalo de nuevo: ");
                            b = input.nextInt();
                        } else if (i >= 3) {
                            System.out.print("Oh, oh... ÚLTIMO intento: ");
                            b = input.nextInt();
                        }
                    }

                    break;

                case 2:
                    String str = "Eliminar vocales";

                    System.out.println("palabra ingresada: " + str);
                    str = str.replaceAll("[AaEeIiOoUu]", "");

                    System.out.println(port.responseMessage(str));
                    break;
                case 3:

                    System.out.println("nombre  ");
                    String nombre = input.next();

                    System.out.println("appeliido paterno ");
                    String appelido = input.next();
                    System.out.println("apellido materno maternos  ");
                    String apellido= input.next();
                    System.out.println("escribe tu fecha nacimiento asi dd/mm/aaaa  ");
                    String fecha= input.next();
                    String rfc = nombre+appelido+apellido+fecha;
                    nombre = nombre.substring(0,1);
                    appelido = appelido.substring(0,2);
                    apellido = apellido.substring(0,1);
                    String anio=fecha.trim().substring(8, 10);
                    String mes=fecha.substring(3,5);
                    String dia=fecha.substring(1, 2);
                    String alpha ="asffdsfsdfsd";
                    String r;
                    Random rd = new Random();
                    r = alpha.charAt(rd.nextInt(alpha.length()-1))+"";
                    r+=rd.nextInt(9)+""+rd.nextInt(9);
                    rfc = appelido+apellido+nombre+anio+mes+dia+r;

                    System.out.println(port.responseMessage(rfc));
                    break;


//        System.out.println("ingresa tu apellido fecha de nacimiento   ");


              //      String response = port.responseMessage();

                //    System.out.println(response);
            }
        }while(opc != 4);

    }
}
