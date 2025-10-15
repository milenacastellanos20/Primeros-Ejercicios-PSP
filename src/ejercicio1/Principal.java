package ejercicio1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String rutaHijo = "ejercicio1.MiniCalc";
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce un numero: ");
            double numero = sc.nextDouble();
            System.out.println("Introduce otro numero: ");
            double numero2 = sc.nextDouble();
            System.out.println("Introduce un operador aritmetico: ");
            char operador = sc.next().charAt(0);


            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), rutaHijo, Double.toString(numero), Double.toString(numero2), Character.toString(operador));
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        } catch (IOException | InputMismatchException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
