package exercicio6.formatadorTelefone;

class MobilePhone extends PhoneBase {

    public MobilePhone() {
        super(true);
    }

    @Override
    public String format(String input) {
        String digits = extractDigits(input);

        if (digits.length() == 9 || digits.length() == 11) {
            return formatWithMask(digits);
        }

        return "Número de telefone móvel (celular) inválido";
    }

    @Override
    protected int getExpectedDigitCount() {
        return 9;
    }

    @Override
    public String getType() {
        return "Telefone móvel (celular)";
    }
}
