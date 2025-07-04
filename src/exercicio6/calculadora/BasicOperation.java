package exercicio6.calculadora;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasicOperation implements MathOperation {
    public List<Double> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
