package exercicio4.usuarioDeSistema;

public class Manager extends User {
    public Manager(String name, String email, String password) {
        super(name, email, password, true);
    }

    public void generateFinancialReport() {
        System.out.println("Relatório financeiro gerado por " + name);
    }

    @Override
    public void checkSales() {
        System.out.println("Gerente " + name + " consultou todas as vendas do sistema.");
    }
}
