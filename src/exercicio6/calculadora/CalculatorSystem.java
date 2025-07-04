package exercicio6.calculadora;

import java.util.List;
import java.util.Scanner;

public class CalculatorSystem {
    private static final Scanner scanner = new Scanner(System.in);
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case ADDITION:
                case SUBTRACTION:
                    processCalculation(choice);
                    break;

                case EXIT:
                    running = false;
                    System.out.println("\nSaindo da calculadora...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nCALCULADORA - SOMA E SUBTRAÇÃO");
        System.out.println("-------------------------------");
        System.out.println(ADDITION + " - Soma");
        System.out.println(SUBTRACTION + " - Subtração");
        System.out.println(EXIT + " - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processCalculation(int operationType) {
        try {
            System.out.print("\nDigite os números separados por vírgula (ex: 5, 3.2, 10): ");
            String numbersInput = scanner.nextLine();

            MathOperation operation = OperationFactory.createOperation(operationType);
            List<Double> numbers = ((BasicOperation)operation).parseNumbers(numbersInput);

            if (numbers.isEmpty()) {
                System.out.println("Erro: Nenhum número válido foi informado!");
                return;
            }

            double result = operation.calculate(numbers);
            System.out.printf("\nResultado da %s: %.2f\n", operation.getOperationName(), result);

        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de número inválido!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}