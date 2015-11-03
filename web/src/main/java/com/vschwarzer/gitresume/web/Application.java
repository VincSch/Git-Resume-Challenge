package com.vschwarzer.gitresume.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class represents the Java based application configuration
 * Created by Vincent Schwarzer on 03.11.15.
 */
@SpringBootApplication
@ComponentScan("com.vschwarzer.gitresume")
public class Application {

    /**
     * Main method.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
