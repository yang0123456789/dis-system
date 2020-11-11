package com.yang.producer;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/10 23:37
 * # @version 1.0
 * # @File : KafkaProducer.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class CustomProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        // kafka 集群， broker-list

        props.put("bootstrap.servers", "127.0.0.1:9092");

        //可用ProducerConfig.ACKS_CONFIG 代替 "acks"
        //props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put("acks", "all");
        // 重试次数
        props.put("retries", 1);
        // 批次大小
        props.put("batch.size", 16384);
        // 等待时间
        props.put("linger.ms", 1);
        // RecordAccumulator 缓冲区大小
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("test", "test-" + Integer.toString(i),
                    "test-" + Integer.toString(i)));
        }
        producer.close();
    }

}