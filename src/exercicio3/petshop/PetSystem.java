package exercicio3.petshop;

import java.util.Scanner;

public class PetSystem {

    private final static Scanner scanner = new Scanner(System.in);

    private final static PetWasher petWasher = new PetWasher();

    public static void main(String[] args) {
        scanner.useDelimiter("\\n");
        var option = -1;

        do {
            System.out.println("====Escolha uma das opções====");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água na máquina");
            System.out.println("5 - Verificar shampoo na máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> petWasher.petBath();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> verifyWasherForPet();
                case 7 -> setPetInWasher();
                case 8 -> petWasher.removePet();
                case 9 -> petWasher.cleanWasher();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção Inválida.");
            }

        } while (true);
    }

    private static void setWater() {
        System.out.println("Tentando colocar água na máquina");
        petWasher.addWater();
    }

    private static void setShampoo() {
        System.out.println("Tentando colocar shampoo na máquina");
        petWasher.addShampoo();
    }

    private static void verifyWater() {
        var amount = petWasher.getWater();
        System.out.println("A máquina está no momento com " + amount + "litro(s) de água");
    }

    private static void verifyShampoo() {
        var amount = petWasher.getShampoo();
        System.out.println("A máquina está no momento com " + amount + "litro(s) de shampoo");
    }

    private static void verifyWasherForPet() {
        var hasPet = petWasher.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina." : "Não tem pet na máquina.");
    }

    public static void setPetInWasher() {
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet.");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petWasher.setPet(pet);

    }


}
