import java.io.IOException;
import java.security.PrivilegedAction;

import lombok.SneakyThrows;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.security.UserGroupInformation;
import pojo.SaleCompositeKey;

public class HadoopRunnerConfig {

        public static void initHadoop(String inputPath, String outputPath) throws IOException {

            UserGroupInformation loginUser = UserGroupInformation.createRemoteUser("root"); // или "makar"
            loginUser.doAs(new PrivilegedAction<Void>() {
                @SneakyThrows
                @Override
                public Void run() {
                    JobConf conf = new JobConf(HadoopRunnerConfig.class);
                    conf.setJobName("SalesAnalysis");

                    conf.setMapOutputKeyClass(Text.class);
                    conf.setMapOutputValueClass(SaleCompositeKey.class);

                    conf.setOutputKeyClass(Text.class);
                    conf.setOutputValueClass(Text.class);

                    conf.setMapperClass(HadoopMapper.class);
                    conf.setReducerClass(HadoopReducer.class);
                    conf.setInputFormat(TextInputFormat.class);
                    conf.setOutputFormat(TextOutputFormat.class);
//                    conf.setOutputValueGroupingComparator(ValueComparator.class);
                    FileInputFormat.setInputPaths(conf,new Path(inputPath));
                    FileOutputFormat.setOutputPath(conf,new Path(outputPath));
                    JobClient.runJob(conf);
                    return null;
                }
            });
        }
}
