package exercicio5.tributos;

public class TaxCalculator {
    public static void main(String[] args) {
        Product[] products = {
                new Food("Arroz", 10.0),
                new HealthWellness("Vitamina C", 25.0),
                new Apparel("Camiseta", 50.0),
                new Culture("Livro", 30.0)
        };

        System.out.println("Cálculo de tributos:");
        for (Product product : products) {
            System.out.printf("%s: $%.2f (Tributo: $%.2f)%n",
                    product.getName(),
                    product.getPrice(),
                    product.calculateTax());
        }

        System.out.println("\nCálculo de tributos:");
        Taxable food = () -> 10.0 * 0.01;
        Taxable health = () -> 25.0 * 0.015;
        Taxable apparel = () -> 50.0 * 0.025;
        Taxable culture = () -> 30.0 * 0.04;

        Taxable[] taxables = {food, health, apparel, culture};
        String[] names = {"Rice ", "Vitamin C ", "T-Shirt ", "Book "};
        double[] prices = {10.0, 25.0, 50.0, 30.0};

        for (int i = 0; i < taxables.length; i++) {
            System.out.printf("%s: $%.2f (Tax: $%.2f)%n",
                    names[i],
                    prices[i],
                    taxables[i].calculateTax());
        }
    }
}
