package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * @author takamis
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {
  
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
}
