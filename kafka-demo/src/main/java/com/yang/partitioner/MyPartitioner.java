package com.yang.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/11 15:28
 * # @version 1.0
 * # @File : MyPartitioner.java
 * # @Software: IntelliJ IDEA
 */

public class MyPartitioner implements Partitioner {

    @Override
    public void configure(Map<String, ?> configs) {
        // TODO Auto-generated method stub

    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

}