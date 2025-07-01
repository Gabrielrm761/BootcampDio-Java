package exercicio5.tributos;

class HealthWellness extends Product {
    public HealthWellness(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * 0.015;
    }
}
