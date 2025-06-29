package exercicio4.usuarioDeSistema;

public class UserSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("Carlos Silva", "carlos@company.com", "password123");
        Salesperson salesperson = new Salesperson("Ana Souza", "ana@company.com", "password456");
        Cashier cashier = new Cashier("João Pereira", "joao@company.com", "password789");

        manager.login();
        manager.generateFinancialReport();
        manager.checkSales();


        manager.changePassword("newPassword123");
        manager.logout();

        salesperson.login();
        salesperson.makeSale();
        salesperson.makeSale();
        salesperson.checkSales();
        salesperson.updateData("Ana Santos", "ana.santos@company.com");
        salesperson.logout();

        cashier.login();
        cashier.receivePayment(150.50);
        cashier.receivePayment(89.90);
        cashier.checkSales();
        cashier.closeRegister();
        cashier.logout();
    }
}
