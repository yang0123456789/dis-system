package com.yang.consumer;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/11 16:27
 * # @version 1.0
 * # @File : CustomConsumer.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class CustomConsumer {
    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "127.0.0.1:9092");
        //消费者组
        props.put("group.id", "abc");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");//消费者重置offset
        props.put("group.id", "abcd");//组id需另设，否则看不出上面一句的配置效果

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList("test1","test2"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}
