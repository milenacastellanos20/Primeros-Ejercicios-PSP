package ejercicio1;

public class MiniCalc {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Argumentos incorrectos");
            return;
        }
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);
        double resultado = 0;
        char operador = args[2].charAt(0);

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.err.println("No se puede dividir por cero");
                    return;
                }
                resultado = num1 / num2;
                break;
        }
        System.out.println(resultado);
    }
}
