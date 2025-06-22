package exercicio1;

import java.util.Scanner;

public class AreaRetangulo {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Digite a base do retângulo: ");
        double base = scanner.nextDouble();
        System.out.print("Digite a altura do retângulo: ");
        double height = scanner.nextDouble();
        double area = base * height;
        System.out.printf("Área do retângulo: %.2f%n", area);

        scanner.close();
    }
}
