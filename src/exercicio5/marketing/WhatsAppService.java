package exercicio5.marketing;

class WhatsAppService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando WhatsApp: " + message);
    }
}
