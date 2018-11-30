package trip.integration.sending;

public interface SendingService {

    void send(String to, String subject, String content);
}
