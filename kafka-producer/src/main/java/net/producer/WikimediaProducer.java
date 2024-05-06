package net.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class WikimediaProducer {
    private static Logger logger = LoggerFactory.getLogger(WikimediaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia";
        EventHandler eventHandler = new WikimediaEventHandler(kafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler,URI.create(url));
        EventSource eventSource = builder.build();

        eventSource.start();
        Thread.sleep(1000000);
    }
}
