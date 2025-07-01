package exercicio5.tributos;

class Culture extends Product {
    public Culture(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * 0.04;
    }
}
