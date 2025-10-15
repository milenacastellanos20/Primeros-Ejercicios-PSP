package ejercicio4;

import java.io.*;

public class Aplicacion2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Argumentos incorrectos. Introduce el nombre del fichero");
            return;
        }
        String nombreFichero = args[0];
        int mayorTemperatura = 0;
        String mayorDiaTemperatura = null;
        int temperatura = 0;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(nombreFichero));
            String linea;
            while ((linea = entrada.readLine()) != null) {
            String[] datos = linea.split(" ");
            temperatura = Integer.parseInt(datos[2]);
            if (temperatura > mayorTemperatura) {
                mayorTemperatura = temperatura;
                mayorDiaTemperatura = linea;
            }
            }
            if (mayorDiaTemperatura != null) {
                System.out.println("Dia mas caluroso: " + mayorDiaTemperatura);
            }else {
                System.err.println("Error al cargar dia mas caluroso");
            }
            entrada.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
