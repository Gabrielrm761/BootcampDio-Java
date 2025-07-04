package exercicio6.formatadorTelefone;

class LandlinePhone extends PhoneBase {

    protected LandlinePhone() {
        super(false);
    }

    @Override
    public String format(String input) {
        String digits = extractDigits(input);

        if (digits.length() == 8 || digits.length() == 10) {
            return formatWithMask(digits);
        }

        return "Número de telefone fixo inválido";
    }

    @Override
    protected int getExpectedDigitCount() {
        return 8;
    }

    @Override
    public String getType() {
        return "Telefone fixo";
    }
}
