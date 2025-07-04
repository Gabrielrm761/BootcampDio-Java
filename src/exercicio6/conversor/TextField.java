package exercicio6.conversor;

class TextField extends Field {
    public TextField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        return value;
    }
}
