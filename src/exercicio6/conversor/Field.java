package exercicio6.conversor;

abstract class Field {
    protected String name;
    protected String value;

    public Field(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public abstract Object getFormattedValue();

    @Override
    public String toString() {
        return name + ": " + getFormattedValue();
    }
}
