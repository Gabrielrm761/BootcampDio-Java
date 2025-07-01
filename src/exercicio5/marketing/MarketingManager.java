package exercicio5.marketing;

import java.util.ArrayList;
import java.util.List;

class MarketingManager {
    private List<MessageService> services;

    public MarketingManager() {
        this.services = new ArrayList<>();
    }

    public void addService(MessageService service) {
        services.add(service);
    }

    public void broadcastMessage(String message) {
        services.forEach(service -> service.sendMessage(message));
    }

    public void sendMessageTo(String message, MessageService... selectedServices) {
        for (MessageService service : selectedServices) {
            service.sendMessage(message);
        }
    }
}
