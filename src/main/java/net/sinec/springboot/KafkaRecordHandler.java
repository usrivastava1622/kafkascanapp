package net.sinec.springboot;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class KafkaRecordHandler implements Runnable {
    private ConsumerRecord<String, String> record;

    public KafkaRecordHandler(ConsumerRecord<String, String> record) {
        this.record = record;
    }

    @Override
    public void run() { // this is where further processing happens
        System.out.println("value = "+record.value());
        System.out.println("Thread id = "+ Thread.currentThread().getId());
    }
}