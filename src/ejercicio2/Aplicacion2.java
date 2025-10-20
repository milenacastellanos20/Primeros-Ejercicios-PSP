package ejercicio2;

import java.util.Arrays;
import java.util.Collections;

public class Aplicacion2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: no argumentos");
            return;
        }
        StringBuilder cadenaRecibida = crearCadena(args);
        String[] palabrasArray = cadenaRecibida.toString().trim().split(" ");
        Arrays.sort(palabrasArray, Collections.reverseOrder());

        StringBuilder ordenada = crearCadena(palabrasArray);
        System.out.println(ordenada.toString());
    }

    private static StringBuilder crearCadena(String[] args) {
        StringBuilder cadenaRecibida = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            cadenaRecibida.append(args[i]);
            if (i < args.length - 1) {
                cadenaRecibida.append(" ");
            }
        }
        return cadenaRecibida;
    }
}