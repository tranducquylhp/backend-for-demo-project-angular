package com.demo.qlhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.demo.qlhs.model")
public class QlhsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlhsApplication.class, args);
    }

}
