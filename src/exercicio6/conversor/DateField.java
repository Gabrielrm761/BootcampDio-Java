package exercicio6.conversor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import java.util.logging.Level;

class DateField extends Field {
    private static final Logger logger = Logger.getLogger(DateField.class.getName());

    private static final SimpleDateFormat[] INPUT_FORMATS = {
            new SimpleDateFormat("dd-MM-yyyy", Locale.US),
            new SimpleDateFormat("yyyy-MM-dd", Locale.US)
    };

    private static final SimpleDateFormat OUTPUT_FORMAT = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

    public DateField(String name, String value) {
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
                // Log detalhado do erro
                logger.log(Level.FINE, "Falha ao parsear data '" + value +
                        "' com formato " + format.toPattern() +
                        ": " + e.getMessage());

                // Adiciona informação útil para debug
                if (logger.isLoggable(Level.FINEST)) {
                    logger.log(Level.FINEST, "Stack trace completo:", e);
                }
            }
        }

        // Log informando que nenhum formato funcionou
        logger.log(Level.WARNING, "Nenhum formato de data válido encontrado para: " + value);
        return value; // Fallback: retorna o valor original
    }
}
