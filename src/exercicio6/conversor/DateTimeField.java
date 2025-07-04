package exercicio6.conversor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

class DateTimeField extends Field {

    private static final Logger logger = Logger.getLogger(DateTimeField.class.getName());

    private static final SimpleDateFormat[] INPUT_FORMATS = {
            new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US),
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
    };

    private static final SimpleDateFormat OUTPUT_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);

    public DateTimeField(String name, String value) {
        super(name, value);
    }

    @Override
    public Object getFormattedValue() {
        for (SimpleDateFormat format : INPUT_FORMATS) {
            try {
                format.setLenient(false);
                Date date = format.parse(value);
                return OUTPUT_FORMAT.format(date);
            } catch (ParseException e) {
                logger.log(Level.FINE, "Falha ao parsear data/hora '" + value +
                        "' com formato " + format.toPattern() +
                        ": " + e.getMessage());

                if (logger.isLoggable(Level.FINEST)) {
                    logger.log(Level.FINEST, "Stack trace:", e);
                }
            }
        }

        logger.log(Level.WARNING, "Data/hora inválida - nenhum formato compatível para: " + value);
        return value;
    }
}
