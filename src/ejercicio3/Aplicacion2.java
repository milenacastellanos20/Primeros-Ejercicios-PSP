package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Aplicacion2 {
    private static final String FICHERO = "FechaYHora.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        String app1 = "ejercicio3.Aplicacion1";
        Random aleatorio = new Random();

        int repeticiones;

        System.out.println("Puedes llamar app1 de 4 a 6 veces, cuantas veces quieres ejecutarla? ");
        repeticiones = sc.nextInt();
        if (repeticiones < 4 || repeticiones > 6) {
            throw new IllegalArgumentException("Introduce una opcion valida. Llamada al proceso fallida.");
        }

        for (int i = 0; i < repeticiones; i++) {
            try {
                if (i == 0) {
                    opcion = "nuevo";
                } else {
                    opcion = "añadir";
                }
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), app1, FICHERO, opcion);
                Process p = pb.start();
                p.waitFor();
                if (i < repeticiones - 1) {
                    int tiempoEspera = aleatorio.nextInt(5000 - 2000 + 1) + 2000;
                    System.out.println("Tiempo de espera: " + tiempoEspera);
                    Thread.sleep(tiempoEspera);
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            System.out.println("leyendo archivo");
            BufferedReader br = new BufferedReader(new FileReader(FICHERO));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
