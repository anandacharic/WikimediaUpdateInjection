package net.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaProducer implements CommandLineRunner {
    public static void main(String args[]){
        SpringApplication.run(KafkaProducer.class);
    }

    @Autowired
    private WikimediaProducer wikimediaProducer;

    @Override
    public void run(String... args) throws Exception{
        wikimediaProducer.sendMessage();
    }
}
