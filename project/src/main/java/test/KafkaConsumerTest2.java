package test;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class KafkaConsumerTest2 {


    public static void main(String[] args) {


        Properties props = new Properties();

        // 必须设置的属性
        props.put("bootstrap.servers", "hubble-kafka1.jd.163.org:9092,hubble-kafka2.jd.163.org:9092,hubble-kafka3.jd.163.org:9092");
        //props.put("bootstrap.servers", "datastream99.jd.163.org:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "easyds_test");

        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset","earliest");
        props.put("client.id", "client_id");
        //props.put("max.poll.interval.ms", "10000");
        props.put("max.poll.records", "10");
        KafkaConsumer<String, String> consumer;// = new KafkaConsumer<>(props);
        //consumer.subscribe(Collections.singletonList("first_topic"));


        while(true) {
            //  从服务器开始拉取数据
            consumer = new KafkaConsumer<>(props);
            //consumer.subscribe(Collections.singletonList("first_topic"));
            consumer.subscribe(Collections.singletonList("azkaban-test"));
            ConsumerRecords<String, String> records = consumer.poll(10000);
            System.out.println("poll");

            for (ConsumerRecord<String, String> record: records) {
                try {
                    System.out.println(new Date());
                    System.out.printf("partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
                    //Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //consumer.commitSync(Collections.singletonMap());
            }
            consumer.close();
            //        record -> { System.out.printf("partition = %d,offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
        }

    }
}
