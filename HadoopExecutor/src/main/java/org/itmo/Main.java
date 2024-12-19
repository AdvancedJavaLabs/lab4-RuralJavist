package org.itmo;


import lombok.SneakyThrows;

public class Main {

    private static final String INPUT_PATH = "hdfs://localhost:9000/user/root/inputs";
    private static final String OUTPUT_PATH = "hdfs://localhost:9000/user/root/outputs/output12";

    @SneakyThrows
    public static void main(String[] args) {

        HadoopRunnerConfig.initHadoop(INPUT_PATH, OUTPUT_PATH);

    }
}
