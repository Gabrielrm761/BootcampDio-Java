package exercicio6.conversor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DataConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Field> fields = new LinkedHashMap<>();

        System.out.println("Digite os campos no formato: NOME_CAMPO;VALOR;TIPO");
        System.out.println("Tipos disponíveis: texto, números inteiros, números com pontos flutuantes, boleanos, datas, data e hora, array");
        System.out.println("Para arrays, separe os valores por vírgula");
        System.out.println("Digite 'sair' para terminar");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            String[] parts = input.split(";");
            if (parts.length != 3) {
                System.out.println("Formato inválido. Use: NOME_CAMPO;VALOR;TIPO");
                continue;
            }

            String name = parts[0].trim();
            String value = parts[1].trim();
            String type = parts[2].trim();

            Field field = FieldFactory.createField(name, value, type);
            fields.put(name, field);
        }

        // Create formatters
        DataFormatter jsonFormatter = new JsonFormatter();
        DataFormatter xmlFormatter = new XmlFormatter();
        DataFormatter yamlFormatter = new YamlFormatter();

        // Generate outputs
        System.out.println("\nJSON:");
        System.out.println(jsonFormatter.format(fields));

        System.out.println("\nXML:");
        System.out.println(xmlFormatter.format(fields));

        System.out.println("\nYAML:");
        System.out.println(yamlFormatter.format(fields));
    }
}
