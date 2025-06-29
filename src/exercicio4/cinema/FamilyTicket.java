package exercicio4.cinema;

public class FamilyTicket extends Ticket {
    private int numberOfPeople;

    public FamilyTicket(double price, String movieName, boolean isDubbed, int numberOfPeople) {
        super(price, movieName, isDubbed);
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double getActualPrice() {
        double totalPrice = super.getActualPrice() * numberOfPeople;

        if (numberOfPeople > 3) {
            totalPrice *= 0.95;
        }

        return totalPrice;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString() {
        return super.toString() + " (Ingresso Família para " + numberOfPeople +
                " pessoas) - Valor final: R$" + String.format("%.2f", getActualPrice());
    }
}
