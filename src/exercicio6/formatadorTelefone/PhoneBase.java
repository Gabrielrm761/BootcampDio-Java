package exercicio6.formatadorTelefone;

abstract class PhoneBase implements PhoneFormatter {
    protected String number;
    protected boolean hasAreaCode;
    protected boolean isMobile;


    protected PhoneBase(boolean isMobile) {
        this.isMobile = isMobile;
        this.hasAreaCode = false;
    }

    @Override
    public boolean isValid(String input) {
        String digits = input.replaceAll("[^0-9]", "");
        return digits.length() == getExpectedDigitCount();
    }

    protected int getExpectedDigitCount() {
        if (this.hasAreaCode) {
            return this.isMobile ? 11 : 10; // Celular com DDD: 11 dígitos; Fixo com DDD: 10
        } else {
            return this.isMobile ? 9 : 8;   // Celular sem DDD: 9 dígitos; Fixo sem DDD: 8
        }
    }

    protected String extractDigits(String input) {
        return input.replaceAll("[^0-9]", "");
    }

    protected String formatWithMask(String digits) {
        int digitCount = digits.length();
        int expectedCount = getExpectedDigitCount();

        hasAreaCode = digitCount == expectedCount + 2;

        if (digitCount == expectedCount || hasAreaCode) {
            if (hasAreaCode) {
                digits = digits.substring(0, digitCount);
            }

            if (!hasAreaCode) {
                if (isMobile) {
                    // Formato para celular sem DDD: 91234-5678
                    return digits.substring(0, 5) + "-" + digits.substring(5);
                } else {
                    // Formato para fixo sem DDD: 1234-5678
                    return digits.substring(0, 4) + "-" + digits.substring(4);
                }
            } else {
                if (isMobile) {
                    // Formato para celular com DDD: (11) 91234-5678
                    return "(" + digits.substring(0, 2) + ") " + digits.substring(2, 7) + "-" + digits.substring(7);
                } else {
                    // Formato para fixo com DDD: (11) 1234-5678
                    return "(" + digits.substring(0, 2) + ") " + digits.substring(2, 6) + "-" + digits.substring(6);
                }
            }
        }
        return digits;
    }
}