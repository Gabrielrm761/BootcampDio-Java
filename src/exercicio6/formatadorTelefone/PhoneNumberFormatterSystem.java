package exercicio6.formatadorTelefone;

import java.util.Scanner;

public class PhoneNumberFormatterSystem {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("\n=== Formatador de Números de Telefone ===");
            System.out.println("1. Formatador um número de telefone");
            System.out.println("2. Testar casos pré-definidos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = getIntInput(1, 3);

            switch (choice) {
                case 1:
                    formatSingleNumber();
                    break;
                case 2:
                    runTestCases();
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void formatSingleNumber() {
        System.out.println("\n=== Formatador de Número ===");
        System.out.print("Digite o número de telefone para formatar: ");
        String input = scanner.nextLine();
        processInput(input);
        System.out.print("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void runTestCases() {
        System.out.println("\n=== Menu de Casos de Teste ===");
        System.out.println("1. Números fixos");
        System.out.println("2. Números móveis (celular)");
        System.out.println("3. Números inválidos");
        System.out.println("4. Todos os casos de teste");
        System.out.println("5. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");

        int choice = getIntInput(1, 5);

        String[][] testCases = {
                // Números fixos
                {"12345678", "Número fixo sem DDD"},
                {"1123456789", "Número fixo com DDD"},
                {"1234-5678", "Número fixo já formatado"},
                {"(11)1234-5678", "Número fixo formatado"},

                // Números móveis
                {"912345678", "Celular sem DDD"},
                {"11912345678", "Celular com DDD"},
                {"(11)91234-5678", "Celular já formatado"},
                {"11 91234 5678", "Celular com espaços"},

                // Números inválidos
                {"12345", "Inválido - muito curto"},
                {"abc12345678xyz", "Número fixo com caracteres extras"},
                {"invalid", "Completamente inválido"}
        };

        switch (choice) {
            case 1: // Fixos
                runSpecificTests(testCases, 0, 3);
                break;
            case 2: // Móveis
                runSpecificTests(testCases, 4, 7);
                break;
            case 3: // Inválidos
                runSpecificTests(testCases, 8, 10);
                break;
            case 4: // Todos
                runAllTests(testCases);
                break;
            case 5: // Voltar
        }
    }

    private static void runSpecificTests(String[][] testCases, int start, int end) {
        System.out.println("\n=== Executando Testes ===");
        for (int i = start; i <= end; i++) {
            System.out.println("\nCaso de teste: " + testCases[i][1]);
            processInput(testCases[i][0]);
        }
        System.out.print("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void runAllTests(String[][] testCases) {
        System.out.println("\n=== Executando Todos os Testes ===");
        String[] categories = {"Números Fixos", "Números Móveis", "Números Inválidos"};
        int[] starts = {0, 4, 8};
        int[] ends = {3, 7, 10};

        for (int i = 0; i < categories.length; i++) {
            System.out.println("\n=== " + categories[i] + " ===");
            runSpecificTests(testCases, starts[i], ends[i]);
        }
    }

    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Por favor, digite um número entre %d e %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, digite um número: ");
            }
        }
    }

    public static void processInput(String input) {
        System.out.println("\nProcessando: " + input);

        PhoneFormatter formatter = PhoneFormatterFactory.createFormatter(input);

        if (formatter == null) {
            System.out.println("Entrada inválida: não corresponde a nenhum formato de telefone conhecido.");
            return;
        }

        String digits = input.replaceAll("[^0-9]", "");
        String formatted = formatter.format(input);

        if (formatted.contains("Inválido")) {
            System.out.println("Entrada inválida: " + input);
        } else {
            if (input.equals(formatted)) {
                System.out.println("Número já formatado corretamente: " + formatted + " (" + formatter.getType() + ")");
            } else if (digits.length() == input.replaceAll("[^0-9]", "").length()) {
                System.out.println("Número formatado: " + formatted + " (" + formatter.getType() + ")");
            } else {
                System.out.println("Número corrigido: " + formatted + " (" + formatter.getType() + ")");
            }
        }
    }
}