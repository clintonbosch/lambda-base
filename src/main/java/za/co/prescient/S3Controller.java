package za.co.prescient;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.eventnotifications.s3.model.S3EventNotification;

/**
 * The purpose of this handler is to kick off a process from and S3 trigger
 */
public class S3Controller implements RequestHandler<String, Void> {

    @Override
    public Void handleRequest(String jsonS3Event, Context context) {
        System.out.println("Message received: " + jsonS3Event);
        S3EventNotification s3EventNotification = S3EventNotification.fromJson(jsonS3Event);
        Utils.process(s3EventNotification);
        return null;
    }
}