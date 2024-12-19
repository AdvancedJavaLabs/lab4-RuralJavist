import lombok.SneakyThrows;

public class Main {

    private static final String INPUT_PATH = "hdfs://localhost:9000/user/root/inputs";
//    private static final String OUTPUT_PATH = "hdfs://localhost:9000/user/root/output/output10";
    private static final String OUTPUT_PATH = "/home/makar/IdeaProjects/ITMO/parallel/lab4-RuralJavist/src/main/resources/output16";
    @SneakyThrows
    public static void main(String[] args) {

        HadoopRunnerConfig.initHadoop(INPUT_PATH, OUTPUT_PATH);

    }
}
