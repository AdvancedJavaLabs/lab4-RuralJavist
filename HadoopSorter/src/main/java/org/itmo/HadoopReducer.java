package org.itmo;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class HadoopReducer extends MapReduceBase implements Reducer<DoubleWritable, Text, Text, Text> {

    @Override
    public void reduce(DoubleWritable key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        if (values.hasNext()) {
            Text currentValue = values.next();
            String[] fields = currentValue.toString().split("\t");

            if (fields.length >= 2) {
                String value = String.format("%s\t%s", key.get(), fields[1]);
                output.collect(new Text(fields[0]), new Text(value));
            } else {
                reporter.incrCounter("ERROR", "Insufficient data", 1);
            }
        }
    }
}
