package exercicio6.conversor;

import java.util.Map;

class XmlFormatter implements DataFormatter {
    @Override
    public String format(Map<String, Field> fields) {
        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n");

        for (Field field : fields.values()) {
            xml.append("  <").append(field.getName()).append(">");
            xml.append(escapeXml(field.getFormattedValue().toString()));
            xml.append("</").append(field.getName()).append(">\n");
        }

        xml.append("</root>");
        return xml.toString();
    }

    private String escapeXml(String input) {
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
