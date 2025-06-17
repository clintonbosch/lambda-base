package za.co.prescient;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;

/**
 * The purpose of this handler is to kick off a process from and SNS trigger
 */
public class SNSController implements RequestHandler<SNSEvent, Void> {

    @Override
    public Void handleRequest(SNSEvent input, Context context) {
        System.out.println("Message received: " + input.toString());
        for (SNSEvent.SNSRecord snsRecord : input.getRecords()) {
            Utils.process(snsRecord);
        }
        return null;
    }
}