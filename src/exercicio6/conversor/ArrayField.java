package exercicio6.conversor;

import java.util.Arrays;

class ArrayField extends Field {
    public ArrayField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        return Arrays.asList(value.split("\\s*,\\s*"));
    }
}
