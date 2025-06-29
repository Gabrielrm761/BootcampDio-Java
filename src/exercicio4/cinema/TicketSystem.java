package exercicio4.cinema;


public class TicketSystem {
    public static void main(String[] args) {
        Ticket standardTicket = new Ticket(30.0, "O Poderoso Chefão", false);
        Ticket halfPriceTicket = new HalfPriceTicket(30.0, "O Poderoso Chefão", false);
        Ticket familyTicket4 = new FamilyTicket(30.0, "O Poderoso Chefão", false, 4);
        Ticket familyTicket2 = new FamilyTicket(30.0, "O Poderoso Chefão", false, 2);

        System.out.println(standardTicket);
        System.out.println(halfPriceTicket);
        System.out.println(familyTicket4);
        System.out.println(familyTicket2);

        System.out.println("\nLista de ingressos:");
        Ticket[] tickets = {standardTicket, halfPriceTicket, familyTicket4, familyTicket2};

        for (Ticket ticket : tickets) {
            System.out.println("- " + ticket.getMovieName() +
                    " | Valor: R$" + String.format("%.2f", ticket.getActualPrice()) +
                    " | Tipo: " + ticket.getClass().getSimpleName());
        }
    }
}
