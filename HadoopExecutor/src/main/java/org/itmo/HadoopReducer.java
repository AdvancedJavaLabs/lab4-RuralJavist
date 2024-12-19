package org.itmo;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.itmo.pojo.SaleCompositeKey;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

public class HadoopReducer extends MapReduceBase implements Reducer<Text, SaleCompositeKey, Text, Text> {

    private final Logger logger = Logger.getLogger(HadoopReducer.class.getName());

    @Override
    public void reduce(Text key, Iterator<SaleCompositeKey> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

        double totalRevenue = 0;
        long totalQuantity = 0L;

        while (values.hasNext()) {
            SaleCompositeKey value = values.next();
            double revenue = value.getRevenue();
            long quantity = value.getQuantity();

            totalRevenue += revenue;
            totalQuantity += quantity;
        }


        String result = String.format("%s\t%d", totalRevenue, totalQuantity);
        logger.info(result);
        output.collect(new Text(key), new Text(result));

    }
}
