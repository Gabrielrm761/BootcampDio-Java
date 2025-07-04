package exercicio6.conversor;

class FieldFactory {
    public static Field createField(String name, String value, String type) {
        switch (type.toLowerCase()) {
            case "números inteiros":
                return new IntegerField(name, value);
            case "números com pontos flutuantes":
                return new FloatField(name, value);
            case "boleanos":
                return new BooleanField(name, value);
            case "datas":
                return new DateField(name, value);
            case "data e hora":
                return new DateTimeField(name, value);
            case "array":
                return new ArrayField(name, value);
            default:
                return new TextField(name, value);
        }
    }
}
