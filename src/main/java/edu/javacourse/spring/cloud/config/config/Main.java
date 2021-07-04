package edu.javacourse.spring.cloud.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@SpringBootApplication
@RestController
@RequestMapping("greeting")
@RefreshScope
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Value("${application.custom.property}")
    private String greeting;

    @GetMapping
    public String greet(@RequestParam("name") String name) {
        return MessageFormat.format("{0}, {1}", greeting, name);
    }
}
