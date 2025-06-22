package exercicio1;

import java.util.Scanner;

public class DiferencaIdade {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Digite o nome da primeira pessoa: ");
        String name1 = scanner.nextLine();
        System.out.print("Digite a idade da primeira pessoa: ");
        int age1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome da segunda pessoa: ");
        String name2 = scanner.nextLine();
        System.out.print("Digite a idade da segunda pessoa: ");
        int age2 = scanner.nextInt();

        int difference = Math.abs(age1 - age2);
        System.out.printf("Diferença de idade entre '%s' e '%s': %d anos%n", name1, name2, difference);

        scanner.close();
    }
}
