package exercicio6.calculadora;

import java.util.List;

public class Subtraction extends BasicOperation {
    @Override
    public double calculate(List<Double> numbers) {
        if (numbers.isEmpty()) return 0;
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return result;
    }

    @Override
    public String getOperationName() {
        return "subtração";
    }
}