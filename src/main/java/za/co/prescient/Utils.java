package za.co.prescient;

import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static void process(SNSEvent.SNSRecord record) {
        String message = record.getSNS().getMessage();
        logger.info("Processing SNS message: {}", message);

        // If the SNS record is as a result of an S3 trigger then the message can be converted to an S3EventNotification
        // Utils.process(S3EventNotification.fromJson(message));
    }

    public static void process(SQSEvent.SQSMessage sqsMessage) {
        logger.info("Processing SQS message: {}", sqsMessage.getBody());
        logger.info("Endpoint = {}", System.getenv(Constants.PARAM_ENDPOINT));
    }

    public static void process(S3EventNotification s3EventNotification) {
        for (S3EventNotification.S3EventNotificationRecord record : s3EventNotification.getRecords()) {
            process(record);
        }
    }

    public static void process(S3EventNotification.S3EventNotificationRecord record) {
        String bucket = record.getS3().getBucket().getName();
        String key = record.getS3().getObject().getKey();
        logger.info("Processing S3 event: bucket = {}, key = {}", bucket, key);
    }
}