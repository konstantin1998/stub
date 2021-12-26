package ru.mipt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class MyConfig {
    @Value("${in.queue.url}")
    private String inQueueUrl;
    @Value("${out.queue.url}")
    private String outQueueUrl;

    @Bean(name = "in")
    public String getInQueueUrl() {
        return inQueueUrl;
    }

    @Bean(name = "out")
    public String getOutQueueUrl() {
        return outQueueUrl;
    }
}
