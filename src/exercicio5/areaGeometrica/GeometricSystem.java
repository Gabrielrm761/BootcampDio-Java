package exercicio5.areaGeometrica;

import java.util.Scanner;

public class GeometricSystem {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        GeometricForm geometricForm;
        while (true) {
            System.out.println("Escolha a forma geométrica para calcular a área:");
            System.out.println("Quadrado");
            System.out.println("Retângulo");
            System.out.println("Círculo");
            System.out.println("Sair");
            option = scanner.nextInt();
            if (option == 1) {
                geometricForm = createSquare();
            }else if (option == 2) {
                geometricForm = createRectangle();
            }else if (option == 3) {
                geometricForm = createCircle();
            }else if (option == 4) {
                System.out.println("Saindo......");
                break;
            } else {
                System.out.println("Opção inválida");
                continue;
            }

            System.out.println("O resultado do cálculo da área foi de " + geometricForm.getArea());
        }
    }

    private static GeometricForm createSquare(){
        System.out.println("Informe o valor dos lados: ");
        var side = scanner.nextDouble();
        return new Square(side);
    }

    private static GeometricForm createRectangle(){
        System.out.println("Informe o valor do comprimento: ");
        var width = scanner.nextDouble();
        System.out.println("Informe o valor da altura: ");
        var height = scanner.nextDouble();
        return new Rectangle(width, height);
    }

    private static GeometricForm createCircle(){
        System.out.println("Informe o valor do raio: ");
        var radius = scanner.nextDouble();
        return new Circle(radius);
    }
}
