package exercicio6.conversor;

class IntegerField extends Field {
    public IntegerField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        return Integer.parseInt(value);
    }
}
