package net.sinec.springboot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ExecutorServiceKafkaConsumer {

  /*  private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorServiceKafkaConsumer.class);

    public Void saveDevice() throws ExecutionException, InterruptedException {
    CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {

        @Override

        public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName());
        }
        @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
        public void consume(String data){
            LOGGER.info(String.format("Json message recieved -> %s", data.toString()));
        }
    }
    );


        return runAsyncFuture.get();
    }
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorServiceKafkaConsumer runAsyncDemo = new ExecutorServiceKafkaConsumer();
            runAsyncDemo.saveDevice();


}*/
}
