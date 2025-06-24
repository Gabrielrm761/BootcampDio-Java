package exercicio3.carro;


import java.util.Scanner;

public class CarSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarController carController = new CarController();

        int option;

        do {
            System.out.println("\n=== MENU DO CARRO ===");
            System.out.println("1 - Ligar carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda");
            System.out.println("6 - Virar para direita");
            System.out.println("7 - Aumentar marcha");
            System.out.println("8 - Diminuir marcha");
            System.out.println("9 - Ver status do carro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    carController.turnOnCar();
                    break;
                case 2:
                    carController.turnOffCar();
                    break;
                case 3:
                    carController.accelerate();
                    break;
                case 4:
                    carController.decelerate();
                    break;
                case 5:
                    carController.turnLeft();
                    break;
                case 6:
                    carController.turnRight();
                    break;
                case 7:
                    carController.shiftUp();
                    break;
                case 8:
                    carController.downShift();
                    break;
                case 9:
                    carController.statusCar();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 0);

        scanner.close();
    }
}