package exercicio2;

import java.util.Scanner;

public class DivisaoComCondicao {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Digite o número inicial: ");
        var initialNumber = scanner.nextInt();

        int number;

        do {
            System.out.print("Digite outro número (ou 0 para sair): ");
            number = scanner.nextInt();

            if (number < initialNumber && number != 0) {
                System.out.println("Número ignorado (menor que o inicial).");
            }

            if (number % initialNumber != 0) {
                System.out.println("Resto diferente de 0. Encerrando...");
                break;
            }

            if (number == 0) {
                System.out.println("0 selecionado. Encerrando...");
                break;
            }

            System.out.println("Número válido: " + number);
        } while (true);

        scanner.close();
    }
}
