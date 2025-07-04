package exercicio6.conversor;

class BooleanField extends Field {
    public BooleanField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        return Boolean.parseBoolean(value);
    }
}
