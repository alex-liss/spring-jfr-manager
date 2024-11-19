package net.alkor.sample;

import org.springframework.boot.SpringApplication;

public class TestSampleApplication {

    public static void main(String[] args) {
        SpringApplication.from(SampleApplication::main).run(args);
    }

}
