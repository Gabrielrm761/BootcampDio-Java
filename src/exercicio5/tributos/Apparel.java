package exercicio5.tributos;

class Apparel extends Product {
    public Apparel(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * 0.025;
    }
}
