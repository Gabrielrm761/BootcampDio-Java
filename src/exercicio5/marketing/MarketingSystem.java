package exercicio5.marketing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarketingManager manager = new MarketingManager();

        MessageService sms = new SMSService();
        MessageService email = new EmailService();
        MessageService socialMedia = new SocialMediaService();
        MessageService whatsapp = new WhatsAppService();

        manager.addService(sms);
        manager.addService(email);
        manager.addService(socialMedia);
        manager.addService(whatsapp);

        while (true) {
            System.out.println("\n=== Marketing Message System ===");
            System.out.println("1. Enviar para todos os serviços");
            System.out.println("2. Selecione os serviços específicos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3) {
                System.out.println("Saindo do sistema...");
                break;
            }

            System.out.print("Coloque sua mensagem: ");
            String message = scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnviando mensagem para todos os serviços:");
                    manager.broadcastMessage(message);
                    break;

                case 2:
                    System.out.println("\nSelecione os serviços:");
                    System.out.println("1. SMS");
                    System.out.println("2. Email");
                    System.out.println("3. Midia social");
                    System.out.println("4. WhatsApp");
                    System.out.println("5. Finalizar seleção");

                    List<MessageService> selectedServices = new ArrayList<>();
                    while (true) {
                        System.out.print("Escolha os serviços (1-5): ");
                        int serviceChoice = scanner.nextInt();

                        if (serviceChoice == 5) break;

                        switch (serviceChoice) {
                            case 1:
                                selectedServices.add(sms);
                                break;
                            case 2:
                                selectedServices.add(email);
                                break;
                            case 3:
                                selectedServices.add(socialMedia);
                                break;
                            case 4:
                                selectedServices.add(whatsapp);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }

                    if (!selectedServices.isEmpty()) {
                        System.out.println("\nEnviando mensagem apenas para os serviços selecionados:");
                        manager.sendMessageTo(message,
                                selectedServices.toArray(new MessageService[0]));
                    } else {
                        System.out.println("Nenhum serviço selecionado !");
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}

