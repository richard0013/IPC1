package principal.common;

import java.util.Locale;
import java.util.Scanner;

public class LectorOpciones {

    private static Scanner sc = new Scanner(System.in);
    private static Character[] abcedario= {'A','B','C','D','E','F','G','H','I'
            ,'J','K','L','M','N','O','P','Q','R'
            ,'S','T','U','V','W','X','Y','Z'};

    private static  String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static  String ANSI_RESET = "\u001B[0m";
    public static String ImprimirTextos(String text){
        System.out.println(text);
        String respuesta = sc.nextLine();
        return respuesta;
    }

    public static String getAnsiRedBackground() {
        return ANSI_RED_BACKGROUND;
    }

    public static String getAnsiReset() {
        return ANSI_RESET;
    }

    public static int Opcion(String text){
        System.out.println(text);
        String respuesta = sc.nextLine();
        int opcion = Integer.parseInt(respuesta);
        return opcion;
    }

    public static Character[] getAbcedario() {
        return abcedario;
    }

    public static int casillaPosision(String mensaje, int columnas, int filas){
        System.out.println(mensaje);
        String respuestatext= sc.nextLine();
        respuestatext = respuestatext.toUpperCase();
        int sumar1=0;
        int sumar2=0;
        int respuesta=-1;
        char[] arreglo= respuestatext.toCharArray();
        for (int i = 0; i < abcedario.length; i++) {
            if (arreglo[0]==abcedario[i]){
                sumar1=1+i;
            }
        }
        sumar2= Integer.parseInt(""+arreglo[1])-1;
        respuesta= (columnas*sumar2)+sumar1;
        if (respuesta<=(columnas*filas)){
            return respuesta-1;
        }else{
            return casillaPosision(mensaje, columnas, filas);
        }

    }
}
