package org.itmo;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class HadoopMapper extends MapReduceBase implements org.apache.hadoop.mapred.Mapper<LongWritable, Text, DoubleWritable, Text> {

    @Override
    public void map(LongWritable key, Text value, OutputCollector<DoubleWritable, Text> output, Reporter reporter) throws IOException {
        String[] fields = value.toString().split("\t");
        if (fields.length == 3) {
            String categoryName = fields[0];
            double sum = Double.parseDouble(fields[1]);
            double quantity = Double.parseDouble(fields[2]);
            String valueRes = String.format("%s\t%s", categoryName, quantity);
            output.collect(new DoubleWritable(sum), new Text(valueRes));
        } else {
            reporter.incrCounter("ERROR", "Insufficient data", 1);
        }
    }
}
