package exercicio3.banco;

import java.util.Scanner;

public class BankSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static BankAccount account;

    public static void main(String[] args) {
        startSystem();
        showMenu();
        scanner.close();
    }

    private static void startSystem() {
        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.print("Digite o valor do depósito inicial: R$");
        double initialDeposit = scanner.nextDouble();
        account = new BankAccount(initialDeposit);
    }

    private static void showMenu() {
        int option;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar dinheiro");
            System.out.println("4. Sacar dinheiro");
            System.out.println("5. Pagar um boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            try {
                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        checkOverdraft();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        withdraw();
                        break;
                    case 5:
                        payBankslip();
                        break;
                    case 6:
                        verifyOverdraft();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (option != 0);
    }

    private static void checkBalance() {
        System.out.printf("Saldo disponível: R$%.2f\n", account.getSaldo());
    }

    private static void checkOverdraft() {
        Overdraft overdraft = account.getChequeEspecial();
        System.out.printf("Limite do cheque especial: R$%.2f\n", overdraft.getLimit());
        System.out.printf("Cheque especial utilizado: R$%.2f\n", overdraft.getUsedOverdraft());
        System.out.printf("Cheque especial disponível: R$%.2f\n", overdraft.getAvailable());
    }

    private static void deposit() {
        System.out.print("Digite o valor a depositar: R$");
        double value = scanner.nextDouble();
        account.depositar(value);
    }

    private static void withdraw() {
        System.out.print("Digite o valor a sacar: R$");
        double value = scanner.nextDouble();
        account.withdraw(value);
    }

    private static void payBankslip() {
        System.out.print("Digite o valor do boleto: R$");
        double value = scanner.nextDouble();
        account.payBankslip(value);
    }

    private static void verifyOverdraft() {
        if (account.getChequeEspecial().getUsedOverdraft() > 0) {
            System.out.println("A conta está usando cheque especial.");
            System.out.printf("Valor utilizado: R$%.2f\n", account.getChequeEspecial().getUsedOverdraft());
        } else {
            System.out.println("A conta não está usando cheque especial.");
        }
    }
}
