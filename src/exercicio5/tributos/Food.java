package exercicio5.tributos;

class Food extends Product {
    public Food(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateTax() {
        return price * 0.01;
    }
}
