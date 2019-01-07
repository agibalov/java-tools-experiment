package me.loki2302;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        try {
            HelloWorldService helloWorldService = context.getBean(HelloWorldService.class);
            helloWorldService.sayHelloWorld();
        } finally {
            context.close();
        }
    }

    @Service
    public static class HelloWorldService {
        public void sayHelloWorld() {
            System.out.println("HelloWorldService says: Hello World!");
        }
    }
}
