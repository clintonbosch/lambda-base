package za.co.prescient;

import com.amazonaws.serverless.proxy.model.Headers;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import jakarta.ws.rs.core.HttpHeaders;
import org.apache.hc.core5.http.HttpStatus;

import java.util.Map;

/**
 * The purpose of this handler is to kick off a process from and S3 trigger
 */
public class ApiGatewayController implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {

    @Override
    public AwsProxyResponse handleRequest(AwsProxyRequest input, Context context) {
        Map<String, String> requestParameters = input.getQueryStringParameters();
        String endpoint = input.getResource();
        try {
            System.out.println(input.getHttpMethod() + " method called on endpoint " + endpoint);
            return buildTextResponse(HttpStatus.SC_OK, "OK");
        } catch (Exception e) {
            return buildTextResponse(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }
    }

    public static AwsProxyResponse buildTextResponse(int code, String body) {
        Headers headers = new Headers();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html");
        return new AwsProxyResponse(code, headers, body);
    }
}