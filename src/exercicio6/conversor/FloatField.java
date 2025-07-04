package exercicio6.conversor;

class FloatField extends Field {
    public FloatField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        return Float.parseFloat(value);
    }
}
