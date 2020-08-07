package test;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class KafkaConsumerTest3 {


    public static void main(String[] args) {


        Properties props = new Properties();

        // 必须设置的属性
        props.put("bootstrap.servers", "hubble-kafka1.jd.163.org:9092,hubble-kafka2.jd.163.org:9092,hubble-kafka3.jd.163.org:9092");
        //props.put("bootstrap.servers", "datastream99.jd.163.org:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "easy_ds_test");

        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset","latest");
        props.put("client.id", "client_id");
        //props.put("max.poll.interval.ms", "10000");
        props.put("max.poll.records", "1");
        KafkaConsumer<String, String> consumer;// = new KafkaConsumer<>(props);
        //consumer.subscribe(Collections.singletonList("first_topic"));

        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("azkaban-test"));

        for (int i = 0; i < 100; i++) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            System.out.println("poll");
            for (ConsumerRecord<String, String> record : records) {
                try {
                    System.out.println(new Date());
                    System.out.printf("partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
                    //Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            consumer.commitSync();
        }
        consumer.close();


    }
}
