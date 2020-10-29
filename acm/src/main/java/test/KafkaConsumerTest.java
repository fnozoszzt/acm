package test;


import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class KafkaConsumerTest {


    public static void main(String[] args) {


        Properties props = new Properties();

        // 必须设置的属性
        props.put("bootstrap.servers", "datastream99.jd.163.org:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "group1");

        // 可选设置属性
        props.put("enable.auto.commit", "true");
        // 自动提交offset,每1s提交一次
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset","earliest");
        props.put("client.id", "client_id");
        props.put("max.poll.interval.ms", "10000");
        props.put("max.poll.records", "6");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("first_topic"));


        while(true) {
            //  从服务器开始拉取数据
            ConsumerRecords<String, String> records = consumer.poll(1000);
            System.out.println("poll");
            records.forEach(record -> {
                try {
                    System.out.println(new Date());
                    System.out.printf("partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            consumer.close();
            //        record -> { System.out.printf("partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
        }

    }
}
