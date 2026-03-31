// Service interface
interface MessageService {
    void sendMessage(String message);
}
// Implementation of MessageService
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("EmailService sending message: " + message);
    }
}
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMSService sending message: " + message);
    }
}
// Client class that depends on MessageService
class Client {
    @Inject
    private MessageService service;
    public void process(String msg) {
        service.sendMessage(msg);
    }
}
