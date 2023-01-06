package net.sinec.springboot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class KafkaProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProcessor.class);

    private final KafkaConsumer<String, String> myConsumer;
    private ExecutorService executor;
    private static final Properties KAFKA_PROPERTIES = new Properties();
    static {
        KAFKA_PROPERTIES.put("bootstrap.servers", "localhost:9092");
        KAFKA_PROPERTIES.put("group.id", "myGroup");
        KAFKA_PROPERTIES.put("enable.auto.commit", "true");
        KAFKA_PROPERTIES.put("auto.commit.interval.ms", "1000");
        KAFKA_PROPERTIES.put("session.timeout.ms", "30000");
        KAFKA_PROPERTIES.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KAFKA_PROPERTIES.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }

    public KafkaProcessor() {
        this.myConsumer = new KafkaConsumer<>(KAFKA_PROPERTIES);
        this.myConsumer.subscribe(Arrays.asList("sinec_json"));
    }

    public void init(int numberOfThreads) {
        //Create a threadpool
        executor = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

        while (true) {
            ConsumerRecords<String, String> records = myConsumer.poll(100);

            for (final ConsumerRecord<String, String> record : records) {
                LOGGER.info(String.format("Json message recieved -> %s", record.toString()));
                executor.submit(new KafkaRecordHandler(record));
            }

        }

    }

    public void shutdown() {
        if (myConsumer != null) {
            myConsumer.close();
        }
        if (executor != null) {
            executor.shutdown();
        }
        try {
            if (executor != null && !executor.awaitTermination(60, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        }catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
