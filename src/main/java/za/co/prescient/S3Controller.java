package za.co.prescient;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

/**
 * The purpose of this handler is to kick off a process from and S3 trigger
 */
public class S3Controller implements RequestHandler<S3Event, Void> {

    @Override
    public Void handleRequest(S3Event s3event, Context context) {
        System.out.println("Message received: " + s3event);
        Utils.process(s3event.getRecords().get(0));
        return null;
    }
}