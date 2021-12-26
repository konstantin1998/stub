package ru.mipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Stub {
    // token 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
    private static String requestQueueUrl;
    private static String responseQueueUrl;
    private static final RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Stub.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();

        requestQueueUrl = context.getBean("in", String.class);
        responseQueueUrl = context.getBean("out", String.class);

        int i = 0;
        while(true) {
            try {
                Request req = getRequest();

                if (req == null) {
                    continue;
                }

                if ( i % 10 <= 4) {
                    Response response = new Response(req.getId(), 200);
                    sendResponse(response);
                }

                if (i % 10 > 4 && i % 10 < 8 ) {
                    Response response = new Response(req.getId(), 500);
                    sendResponse(response);
                }

                i++;
            } catch (HttpClientErrorException | ResourceAccessException e) {
                Thread.sleep(1);
            }
        }

    }

    private static Request getRequest() {
        return restTemplate.getForObject(requestQueueUrl + "/getRequest", Request.class);
    }

    private static void sendResponse(Response response) {
        restTemplate.put(responseQueueUrl + "/putResponse", response);
    }

}
