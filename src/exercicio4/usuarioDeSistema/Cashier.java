package exercicio4.usuarioDeSistema;

public class Cashier extends User {
    private double cashRegisterAmount;

    public Cashier(String name, String email, String password) {
        super(name, email, password, false);
        this.cashRegisterAmount = 0.0;
    }

    public void receivePayment(double amount) {
        cashRegisterAmount += amount;
        System.out.println("Pagamento de R$" + amount + " recebido. Caixa atual: R$" + cashRegisterAmount);
    }

    public void closeRegister() {
        System.out.println("Caixa fechado por " + getName() + ". Valor final: R$" + cashRegisterAmount);
        cashRegisterAmount = 0.0;
    }

    @Override
    public void checkSales() {
        System.out.println("Atendente " + getName() + " consultou o valor em caixa: R$" + cashRegisterAmount);
    }

    public double getCashRegisterAmount() {
        return cashRegisterAmount;
    }
}
