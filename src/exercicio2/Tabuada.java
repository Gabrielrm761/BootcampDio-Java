package exercicio2;

import java.util.Scanner;

public class Tabuada {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Digite um número para gerar a tabuada: ");
        int number = scanner.nextInt();

        System.out.println("Tabuada do " + number + ":");
        for(int i = 1; i <= 10; i++){
            System.out.println(number + "x" + i + "=" + (number * i));
        }

        scanner.close();
    }
}
