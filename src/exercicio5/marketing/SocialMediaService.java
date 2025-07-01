package exercicio5.marketing;

class SocialMediaService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Postando em Redes Sociais: " + message);
    }
}
