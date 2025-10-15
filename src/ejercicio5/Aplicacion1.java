package ejercicio5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        int numero;
        String app2 = "ejercicio5.Aplicacion2";

        System.out.println("Introduce numeros enteros positivos");
        do {
            System.out.println("Introduce un numero entero: ");
            numero = sc.nextInt();
            if (numero > 0) {
                lista.add(numero);
            }
        }while (!(numero <= 0));

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), app2);
            Process p = pb.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            for(int num : lista){
                bw.write(String.valueOf(num));
                bw.newLine();
            }
            bw.close();
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
