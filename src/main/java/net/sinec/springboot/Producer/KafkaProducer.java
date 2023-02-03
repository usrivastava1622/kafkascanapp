package net.sinec.springboot.Producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducer  {


    public void produceRange(String ip1,String ip2)
    {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        org.apache.kafka.clients.producer.KafkaProducer<String,String> producer=new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("command", ip1);
        ProducerRecord<String, String> producerRecord2 =
                new ProducerRecord<>("command", ip2);
        producer.send(producerRecord);
        producer.send(producerRecord2);
    }

}
