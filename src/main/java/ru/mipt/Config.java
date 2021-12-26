package ru.mipt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Config {
    @Value("${in.queue.url}")
    private String inQueueUrl;
    @Value("${out.queue.url}")
    private String outQueueUrl;

    public String getInQueueUrl() {
        return inQueueUrl;
    }

    public String getOutQueueUrl() {
        return outQueueUrl;
    }
}
