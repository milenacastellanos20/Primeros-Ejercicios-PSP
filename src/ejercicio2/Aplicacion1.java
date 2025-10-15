package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aplicacion1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String rutaHijo = "ejercicio2.Aplicacion2";
        StringBuilder cadena = new StringBuilder();

        System.out.println("Cuantas palabras quiere introducir? ");
        int cantidadPalabras = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidadPalabras; i++) {
            System.out.println("Ingrese palabra " + (i + 1) + ": ");
            cadena.append(sc.nextLine()).append(" ");
        }
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), rutaHijo, cadena.toString().trim());
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String[] palabras = null;
            while ((line = br.readLine()) != null) {
                palabras = line.split(" ");
            }
            p.waitFor();
            br.close();
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
            System.out.println("Hay " + palabras.length + " palabras");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
