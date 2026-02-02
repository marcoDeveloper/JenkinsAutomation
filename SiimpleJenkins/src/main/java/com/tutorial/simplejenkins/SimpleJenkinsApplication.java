package com.tutorial.simplejenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tutorial.simplejenkins", "tutorial.controller"})
public class SimpleJenkinsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleJenkinsApplication.class, args);
  }
}
