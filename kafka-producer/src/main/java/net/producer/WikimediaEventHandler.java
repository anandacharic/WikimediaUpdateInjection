package net.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaEventHandler implements EventHandler{

    private static Logger logger = LoggerFactory.getLogger(WikimediaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
    private String kafkaTopic;

    public WikimediaEventHandler(KafkaTemplate<String, String> kafkaTemplate, String kafkaTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopic = kafkaTopic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        logger.info(String.format("Wikimedia Data %s",messageEvent.getData()));
        kafkaTemplate.send(kafkaTopic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
