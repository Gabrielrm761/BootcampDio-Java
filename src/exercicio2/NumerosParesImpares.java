package exercicio2;

import java.util.Scanner;

public class NumerosParesImpares {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        var number1 = scanner.nextInt();

        System.out.print("Digite o segundo número(maior que o primeiro): ");
        var number2 = scanner.nextInt();

        System.out.print("Escolha (1-Pares / 2-Ímpares): ");
        var option = scanner.nextInt();

        System.out.println("Números no intervalo [" + number1 + ", " + number2 + "]");
        for (int i = number2; i >= number1; i--) {
            if (option == 1 && i % 2 == 0) {
                System.out.println(i);
            } else if (option == 2 && i % 2 != 0) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
