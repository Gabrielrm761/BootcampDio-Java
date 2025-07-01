package exercicio5.marketing;

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
