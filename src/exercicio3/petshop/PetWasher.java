package exercicio3.petshop;

public class PetWasher {

    private boolean washerIsClean = true;

    private int water = 30;

    private int shampoo = 10;

    private Pet pet;

    public void petBath() {
        if (this.pet == null) {
            System.out.println("Nenhum pet encontrado para o banho, coloque um pet para iniciar o banho.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("Banho concluído, o " + pet.getName() + " está limpinho!");
    }

    public void addWater() {
        if (water == 30) {
            System.out.println("Capacidade máxima de água atingida!");
            return;
        }

        water += 2;
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("Capacidade máxima de shampoo atingida!");
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.washerIsClean) {
            System.out.println("A máquina está suja, limpe-a antes de colocar um novo pet.");
            return;
        }

        if (hasPet()) {
            System.out.println("O pet, " + this.pet.getName() + "está na máquina!");
            return;
        }

        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void removePet() {
        this.washerIsClean = !this.pet.petIsClean();
        System.out.println("O pet, " + pet.getName() + " foi retirado da máquina");
        this.pet = null;
    }

    public void cleanWasher() {
        this.water -= 10;
        this.shampoo -= 2;
        this.washerIsClean = true;
        System.out.println("A máquina foi limpa!");
    }
}
