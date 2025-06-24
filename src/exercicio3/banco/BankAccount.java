package exercicio3.banco;

class BankAccount {
    private double saldo;
    private final Overdraft chequeEspecial;

    public BankAccount(double depositoInicial) {
        if (depositoInicial < 0) {
            throw new IllegalArgumentException("Depósito inicial não pode ser negativo");
        }
        this.saldo = depositoInicial;
        this.chequeEspecial = new Overdraft(depositoInicial);
    }

    public double getSaldo() {
        return saldo;
    }

    public Overdraft getChequeEspecial() {
        return chequeEspecial;
    }

    public double getSaldoTotalDisponivel() {
        return saldo + chequeEspecial.getAvailable();
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }

        if (chequeEspecial.getUsedOverdraft() > 0) {
            double valorParaPagar = Math.min(valor, chequeEspecial.getUsedOverdraft());
            double taxa = valorParaPagar * chequeEspecial.getFee();

            System.out.printf("Pagando R$%.2f do cheque especial + R$%.2f de taxa...\n",
                    valorParaPagar, taxa);

            chequeEspecial.payOverdraft(valorParaPagar);
            valor -= (valorParaPagar + taxa);
        }

        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depositado R$%.2f no saldo.\n", valor);
        }
    }

    public void withdraw(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Valor de saque inválido");
        }

        if (value > getSaldoTotalDisponivel()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        if (value <= saldo) {
            saldo -= value;
            System.out.printf("Saque de R$%.2f realizado com sucesso.\n", value);
        } else {
            double usingOverdraftValue = value - saldo;
            chequeEspecial.useOverdraft(usingOverdraftValue);
            saldo = 0;
            System.out.printf("Saque de R$%.2f realizado usando R$%.2f do cheque especial.\n",
                    value, usingOverdraftValue);
        }
    }

    public void payBankslip(double value) {
        withdraw(value);
        System.out.println("Boleto pago com sucesso.");
    }
}
