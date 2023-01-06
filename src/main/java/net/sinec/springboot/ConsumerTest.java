package net.sinec.springboot;
public class ConsumerTest {

    public static void main(String[] args) {
        KafkaProcessor processor = new KafkaProcessor();
        try {
            processor.init(1);
        }catch (Exception exp) {
            processor.shutdown();
        }
    }


}