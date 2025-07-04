package exercicio6.formatadorTelefone;

interface PhoneFormatter {
    String format(String input);
    boolean isValid(String input);
    String getType();
}
