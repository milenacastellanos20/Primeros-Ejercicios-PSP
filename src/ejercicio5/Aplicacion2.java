package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Aplicacion2 {
    public static void main(String[] args) {
        ArrayList<Integer> entrada = new ArrayList<>();
        double media;
        int suma = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while((linea = br.readLine()) != null){
                int numero = Integer.parseInt(linea.trim());
                entrada.add(numero);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (entrada.isEmpty()){
            System.err.println("No hay numeros encontrados");
        }
        entrada.sort(Collections.reverseOrder());

        int mayor = Collections.max(entrada);
        int mayor2 = entrada.get(1);

        int menor = Collections.min(entrada);
        Map<Integer,Integer> repeticiones = new HashMap<>();
        for(int num : entrada){
            suma += num;
        }

        media = (double) suma/entrada.size();

        Collections.sort(entrada);
        int repetido = entrada.get(0);
        int maxFrecuencia = 1;
        int contadorRepes = 1;

        for (int i = 1; i < entrada.size(); i++) {
            if (entrada.get(i).equals(entrada.get(i - 1))) {
                contadorRepes++;
            }else {
                contadorRepes = 1;
            }
            if(contadorRepes > maxFrecuencia){
                maxFrecuencia = contadorRepes;
                repetido = entrada.get(i);
            }
        }
        System.out.println("Mayor: " + mayor);
        System.out.println("Mayor2: " + mayor2);
        System.out.println("Menor: " + menor);
        System.out.println("Media: " + media);
        System.out.println("Repetido: " + repetido);
    }
}
