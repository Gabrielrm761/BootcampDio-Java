package exercicio4.cinema;

public class Ticket {

    private double price;
    private String movieName;
    private boolean isDubbed;

    public Ticket(double price, String movieName, boolean isDubbed) {
        this.price = price;
        this.movieName = movieName;
        this.isDubbed = isDubbed;
    }

    public double getActualPrice() {
        return price;
    }

    public String getMovieName() {
        return movieName;
    }

    public boolean isDubbed() {
        return isDubbed;
    }

    @Override
    public String toString() {
        return "Ingresso para '" + movieName + "' (" + (isDubbed ? "Dublado" : "Legendado") +
                ") - Valor base: R$" + String.format("%.2f", price);
    }
}
