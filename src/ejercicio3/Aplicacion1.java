package ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Aplicacion1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Argumentos incorrectos.");
            return;
        }
        String nombreFichero = args[0];
        String opcion = args[1];
        LocalDateTime fechayhora = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        boolean append = opcion.equalsIgnoreCase("añadir"); //Tuve que investigar esto para que no se sobreescriba el fichero cada vez que se ejecuta
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, append));
            if (opcion.equalsIgnoreCase("nuevo")) {
                bw.write(fechayhora.format(dtf));
            } else if (opcion.equalsIgnoreCase("añadir")) {
                bw.newLine();
                bw.write(fechayhora.format(dtf));
            } else {
                throw new InputMismatchException();
            }
            bw.close();
        } catch (IOException | InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }
}
