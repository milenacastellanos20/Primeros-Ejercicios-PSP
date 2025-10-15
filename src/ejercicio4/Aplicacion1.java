package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formattable;
import java.util.Random;

public class Aplicacion1 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Argumentos incorrectos, min/max/fichero");
            return;
        }
        Random aleatorio = new Random();
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        if (min > max) {
            System.err.println("El primer valor no puede ser mayor al segundo");
            return;
        }
        String nombreFichero = args[2];
        int temperatura = aleatorio.nextInt(max - min + 1) + min;

        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true)); //Para que no se borre el contenido en cada ejecucion
            bw.write(fecha.format(fechaFormateada) + " " + temperatura);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
