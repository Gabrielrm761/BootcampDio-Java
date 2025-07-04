package exercicio6.calculadora;

import java.util.List;

public class Addition extends BasicOperation {
    @Override
    public double calculate(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public String getOperationName() {
        return "soma";
    }
}