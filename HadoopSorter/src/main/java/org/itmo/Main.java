package org.itmo;

import lombok.SneakyThrows;

public class Main {

    private static final String INPUT_PATH = "hdfs://localhost:9000/user/root/outputs/output12/part-00000";
    private static final String OUTPUT_PATH = "/home/makar/IdeaProjects/ITMO/parallel/lab4-RuralJavist/src/main/resources/output16";

    @SneakyThrows
    public static void main(String[] args) {
        HadoopRunnerConfig.initHadoop(INPUT_PATH, OUTPUT_PATH);
    }
}