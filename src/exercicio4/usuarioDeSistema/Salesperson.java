package exercicio4.usuarioDeSistema;

public class Salesperson extends User {
    private int salesCount;

    public Salesperson(String name, String email, String password) {
        super(name, email, password, false);
        this.salesCount = 0;
    }

    public void makeSale() {
        salesCount++;
        System.out.println("Venda realizada por " + name + ". Total de vendas: " + salesCount);
    }

    @Override
    public void checkSales() {
        System.out.println("Vendedor " + name + " consultou suas vendas. Total: " + salesCount);
    }

    public int getSalesCount() {
        return salesCount;
    }
}