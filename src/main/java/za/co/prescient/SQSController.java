package za.co.prescient;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

/**
 * The purpose of this handler is to kick off a process from and SNS trigger
 */
public class SQSController implements RequestHandler<SQSEvent, String> {

    @Override
    public String handleRequest(SQSEvent input, Context context) {
        System.out.println("Message received: " + input.toString());
        for (SQSEvent.SQSMessage sqsMessage : input.getRecords()) {
            Utils.process(sqsMessage);
        }
        return "OK";
    }

}