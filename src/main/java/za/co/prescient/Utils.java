package za.co.prescient;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import software.amazon.awssdk.eventnotifications.s3.model.S3EventNotification;
import software.amazon.awssdk.eventnotifications.s3.model.S3EventNotificationRecord;

public class Utils {

    public static void process(SNSEvent.SNSRecord record) {
        String message = record.getSNS().getMessage();
        System.out.println("Processing " + message);

        // If the SNS record is as a result of an S3 trigger then the message can be converted to an S3EventNotification
//        Utils.process(S3EventNotification.fromJson(message));
    }

    public static void process(SQSEvent.SQSMessage sqsMessage) {
        System.out.println("Processing: " + sqsMessage.getBody());
    }

    public static void process(S3EventNotification s3EventNotification) {
        for (S3EventNotificationRecord record : s3EventNotification.getRecords()) {
            process(record);
        }
    }

    public static void process(S3EventNotificationRecord record) {
        String bucket = record.getS3().getBucket().getName();
        String key = record.getS3().getObject().getKey();
        System.out.println("Processing: " + bucket + " : " + key);
    }

}