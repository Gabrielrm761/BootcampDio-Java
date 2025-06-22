package exercicio1;

import java.time.OffsetDateTime;
import java.util.Scanner;

public class NomeIdade {

    public static void main(String[] args) {
        var baseYear = OffsetDateTime.now().getYear();
        var scanner = new Scanner(System.in);
        System.out.println("Informe o seu nome:");
        var name = scanner.next();
        System.out.println("Informe o seu nascimento:");
        var year = scanner.nextInt();
        var age = baseYear - year;
        System.out.printf("Olá %s você tem %s anos \n ", name, age);

        scanner.close();
    }
}

