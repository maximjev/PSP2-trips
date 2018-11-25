package trip.smsSendingService;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import trip.sendingServiceAPI.SendingService;

import java.util.ArrayList;
import java.util.List;

import static com.twilio.sdk.examples.RestExamples.ACCOUNT_SID;
import static com.twilio.sdk.examples.RestExamples.AUTH_TOKEN;

public class SMSSendingService implements SendingService {

    private String TWILIO_NUMBER = "+3706453211";

    @Override
    public void send(String to, String subject, String content) {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("Body", subject + "\n" + content));
            params.add(new BasicNameValuePair("To", to));
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            System.out.println(message.getSid());
        }
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
