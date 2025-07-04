package exercicio6.conversor;

import java.util.Date;
import java.util.List;
import java.util.Map;

class JsonFormatter implements DataFormatter {
    @Override
    public String format(Map<String, Field> fields) {
        StringBuilder json = new StringBuilder("{\n");
        boolean first = true;

        for (Field field : fields.values()) {
            if (!first) {
                json.append(",\n");
            }
            first = false;

            json.append("  \"").append(field.getName()).append("\": ");
            Object value = field.getFormattedValue();

            if (value instanceof String) {
                json.append("\"").append(escapeJson(value.toString())).append("\"");
            } else if (value instanceof List) {
                json.append("[");
                boolean firstItem = true;
                for (Object item : (List<?>) value) {
                    if (!firstItem) {
                        json.append(", ");
                    }
                    firstItem = false;
                    json.append("\"").append(escapeJson(item.toString())).append("\"");
                }
                json.append("]");
            } else {
                json.append(value);
            }
        }

        json.append("\n}");
        return json.toString();
    }

    private String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}