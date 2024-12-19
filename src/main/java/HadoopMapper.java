import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import pojo.SaleCompositeKey;

import java.io.IOException;
import java.util.logging.Logger;

public class HadoopMapper extends MapReduceBase implements org.apache.hadoop.mapred.Mapper<Object,Text, Text, SaleCompositeKey> {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

//    transaction_id, product_id, category, price, quantity

    @Override
    public void map(Object key, Text value, OutputCollector<Text, SaleCompositeKey> output, Reporter reporter) throws IOException {
        String line = value.toString();
        if (line.startsWith("transaction_id")) {
            return;
        }
        String[] fields = line.split(",");
        String category = fields[2];

        double price = Double.parseDouble(fields[3]);
        long quantity = Long.parseLong(fields[4]); // Используем long для quantity
        double revenue = price * quantity;
        output.collect(new Text(category), new SaleCompositeKey(quantity, revenue));

    }
}
