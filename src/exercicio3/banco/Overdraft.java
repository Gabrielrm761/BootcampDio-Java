package exercicio3.banco;

class Overdraft {
    private double limit;
    private double used;
    private final double fee = 0.20; // 20%

    public Overdraft(double initialDeposit) {
        setLimit(initialDeposit);
        this.used = 0;
    }

    private void setLimit(double initialDeposit) {
        this.limit = (initialDeposit <= 500) ? 50 : initialDeposit * 0.5;
    }

    public double getLimit() {
        return limit;
    }

    public double getUsedOverdraft() {
        return used;
    }

    public double getAvailable() {
        return limit - used;
    }

    public double getFee() {
        return fee;
    }

    public void useOverdraft(double value) {
        if (value <= 0 || value > getAvailable()) {
            throw new IllegalArgumentException("Valor inválido ou limite excedido");
        }
        used += value;
    }

    public void payOverdraft(double value) {
        if (value <= 0 || value > used) {
            throw new IllegalArgumentException("Valor inválido ou maior que o utilizado");
        }
        used -= value;
    }
}
