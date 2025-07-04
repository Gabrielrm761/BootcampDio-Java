package exercicio6.calculadora;

import java.util.List;

public interface MathOperation {
    double calculate(List<Double> numbers);
    String getOperationName();
}
