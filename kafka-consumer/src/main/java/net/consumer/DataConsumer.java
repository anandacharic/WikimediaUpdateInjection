package net.consumer;

import net.consumer.entity.WikimediaData;
import net.consumer.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DataConsumer{
    private static final Logger logger = LoggerFactory.getLogger(DataConsumer.class);
    private WikimediaRepository wikimediaRepository;

    public DataConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "wikimedia",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        logger.info(String.format("Received %s",eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage.substring(0,200));

        wikimediaRepository.save(wikimediaData);
    }
}
