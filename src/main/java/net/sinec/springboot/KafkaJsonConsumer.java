package net.sinec.springboot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

//    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consume(String data){
//        LOGGER.info(String.format("Json message recieved -> %s", data.toString()));
//    }
}
