package exercicio4.cinema;

public class HalfPriceTicket extends Ticket {

    public HalfPriceTicket(double price, String movieName, boolean isDubbed) {
        super(price, movieName, isDubbed);
    }

    @Override
    public double getActualPrice() {
        return super.getActualPrice() / 2;
    }

    @Override
    public String toString() {
        return super.toString() + " (Meia Entrada) - Valor final: R$" +
                String.format("%.2f", getActualPrice());
    }
}
