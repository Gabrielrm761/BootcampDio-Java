package exercicio6.calculadora;

public class OperationFactory {
    public static MathOperation createOperation(int operationType) {
        switch (operationType) {
            case 1:
                return new Addition();
            case 2:
                return new Subtraction();
            default:
                throw new IllegalArgumentException("Operação inválida");
        }
    }
}