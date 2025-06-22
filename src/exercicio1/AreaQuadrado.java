package exercicio1;

import java.util.Scanner;

public class AreaQuadrado {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Digite o lado do quadrado: ");
        var side = scanner.nextDouble();
        var area = side * side;
        System.out.println("A area do quadrado é: " + area);

        scanner.close();
    }
}
