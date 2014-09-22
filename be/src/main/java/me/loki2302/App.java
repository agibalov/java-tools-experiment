package me.loki2302;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class App {
    public static void main(String[] args) {
        SpringApplication.run(HomeController.class);
    }

    @Controller
    @EnableAutoConfiguration
    public static class HomeController {
        @RequestMapping("/")
        @ResponseBody
        public String index() {
            return "hello there";
        }
    }
}