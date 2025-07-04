package exercicio6.conversor;

import java.util.Date;
import java.util.List;
import java.util.Map;

class YamlFormatter implements DataFormatter {
    @Override
    public String format(Map<String, Field> fields) {
        StringBuilder yaml = new StringBuilder();
        boolean first = true;

        for (Field field : fields.values()) {
            if (!first) {
                yaml.append("\n");
            }
            first = false;

            yaml.append(field.getName()).append(": ");
            Object value = field.getFormattedValue();

            if (value instanceof String) {
                // Se já é uma string formatada (como datas), usa diretamente
                yaml.append(value);
            } else if (value instanceof List) {
                yaml.append("\n");
                for (Object item : (List<?>) value) {
                    yaml.append("  - ").append(item).append("\n");
                }
            } else {
                yaml.append(value);
            }
        }

        return yaml.toString();
    }
}
