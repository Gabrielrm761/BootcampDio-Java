package exercicio6.formatadorTelefone;

class PhoneFormatterFactory {
    public static PhoneFormatter createFormatter(String input) {
        String digits = input.replaceAll("[^0-9]", "");

        if (digits.length() == 8 || digits.length() == 10) {
            return new LandlinePhone();
        } else if (digits.length() == 9 || digits.length() == 11) {
            return new MobilePhone();
        }

        return null;
    }
}
