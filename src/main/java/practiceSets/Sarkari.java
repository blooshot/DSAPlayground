package practiceSets;//package practiceSets;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Properties;
//import java.util.concurrent.CountDownLatch;
//package io.conduktor.demos.kafka;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.TopicPartition;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//package io.conduktor.demos.kafka;
//
//import org.apache.kafka.clients.consumer.*;
//import org.apache.kafka.common.errors.WakeupException;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Properties;
//import java.util.concurrent.CountDownLatch;
//public class Sarkari {
//}
//
//public class ConsumerDemoAssignSeek {
//    public static void main(String[] args) {
//
//        Logger log = LoggerFactory.getLogger(ConsumerDemoAssignSeek.class.getName());
//
//        String bootstrapServers = "127.0.0.1:9092";
//        String topic = "demo_java";
//
//        // create consumer configs
//        Properties properties = new Properties();
//        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//        // create consumer
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
//
//        // assign and seek are mostly used to replay data or fetch a specific message
//
//        // assign
//        TopicPartition partitionToReadFrom = new TopicPartition(topic, 0);
//        long offsetToReadFrom = 7L;
//        consumer.assign(Arrays.asList(partitionToReadFrom));
//
//        // seek
//        consumer.seek(partitionToReadFrom, offsetToReadFrom);
//
//        int numberOfMessagesToRead = 5;
//        boolean keepOnReading = true;
//        int numberOfMessagesReadSoFar = 0;
//
//        // poll for new data
//        while(keepOnReading){
//            ConsumerRecords<String, String> records =
//                    consumer.poll(Duration.ofMillis(100));
//
//            for (ConsumerRecord<String, String> record : records){
//                numberOfMessagesReadSoFar += 1;
//                log.info("Key: " + record.key() + ", Value: " + record.value());
//                log.info("Partition: " + record.partition() + ", Offset:" + record.offset());
//                if (numberOfMessagesReadSoFar >= numberOfMessagesToRead){
//                    keepOnReading = false; // to exit the while loop
//                    break; // to exit the for loop
//                }
//            }
//        }
//
//        log.info("Exiting the application");
//
//    }
//}
//
//
//public class ConsumerDemoThreads {
//
//    public static void main(String[] args)  {
//        ConsumerDemoWorker consumerDemoWorker = new ConsumerDemoWorker();
//        new Thread(consumerDemoWorker).start();
//        Runtime.getRuntime().addShutdownHook(new Thread(new ConsumerDemoCloser(consumerDemoWorker)));
//    }
//
//    private static class ConsumerDemoWorker implements Runnable {
//
//        private static final Logger log = LoggerFactory.getLogger(ConsumerDemoWorker.class);
//
//        private CountDownLatch countDownLatch;
//        private Consumer<String, String> consumer;
//
//        @Override
//        public void run() {
//            countDownLatch = new CountDownLatch(1);
//            final Properties properties = new Properties();
//
//            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-sixth-application");
//            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//            consumer = new KafkaConsumer<>(properties);
//            consumer.subscribe(Collections.singleton("demo_java"));
//
//            final Duration pollTimeout = Duration.ofMillis(100);
//
//            try {
//                while (true) {
//                    final ConsumerRecords<String, String> consumerRecords = consumer.poll(pollTimeout);
//                    for (final ConsumerRecord<String, String> consumerRecord : consumerRecords) {
//                        log.info("Getting consumer record key: '" + consumerRecord.key() + "', value: '" + consumerRecord.value() + "', partition: " + consumerRecord.partition() + " and offset: " + consumerRecord.offset() + " at " + new Date(consumerRecord.timestamp()));
//                    }
//                }
//            } catch (WakeupException e) {
//                log.info("Consumer poll woke up");
//            } finally {
//                consumer.close();
//                countDownLatch.countDown();
//            }
//        }
//
//        void shutdown() throws InterruptedException {
//            consumer.wakeup();
//            countDownLatch.await();
//            log.info("Consumer closed");
//        }
//
//    }
//
//    private static class ConsumerDemoCloser implements Runnable {
//
//        private static final Logger log = LoggerFactory.getLogger(ConsumerDemoCloser.class);
//
//        private final ConsumerDemoWorker consumerDemoWorker;
//
//        ConsumerDemoCloser(final ConsumerDemoWorker consumerDemoWorker) {
//            this.consumerDemoWorker = consumerDemoWorker;
//        }
//
//        @Override
//        public void run() {
//            try {
//                consumerDemoWorker.shutdown();
//            } catch (InterruptedException e) {
//                log.error("Error shutting down consumer", e);
//            }
//        }
//    }
//
//}
//
