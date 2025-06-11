package za.co.prescient;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

/**
 * The purpose of this handler is to kick off a process from and S3 trigger
 */
public class S3Controller implements RequestHandler<S3Event, String> {

    @Override
    public String handleRequest(S3Event input, Context context) {
//        System.out.println("Message received: " + input.toString());
//        S3EventNotification s3EventNotification = S3EventNotification.fromJson(input.toString());
//        Utils.process(s3EventNotification);
        return "OK";
    }

}