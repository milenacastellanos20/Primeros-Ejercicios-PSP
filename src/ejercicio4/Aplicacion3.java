package ejercicio4;

import java.io.IOException;

public class Aplicacion3 {
    public static void main(String[] args) {
        String app1 = "ejercicio4.Aplicacion1";
        String app2 = "ejercicio4.Aplicacion2";
        String fichero = "tiempo.txt";
        int max = 40;
        int min = 0;

        try {
            for (int i = 0; i < 4; i++) {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), app1, Integer.toString(min), Integer.toString(max), fichero);
                Process p = pb.start();
                p.waitFor();
                Thread.sleep(1000);
            }
            ProcessBuilder pb2 = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), app2, fichero);
            pb2.inheritIO();
            Process p2 = pb2.start();
            p2.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
