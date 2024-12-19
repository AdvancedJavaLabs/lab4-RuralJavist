package org.itmo;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
import org.itmo.pojo.SaleResult;

public class CustomPartitioner extends Partitioner<Text, SaleResult> {

    @Override
    public int getPartition(Text key, SaleResult saleResult, int numPartitions) {
        return (key.hashCode() & Integer.MAX_VALUE) % numPartitions;
    }
}
