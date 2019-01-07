package me.loki2302;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class App {
    public static void main(String[] args) {
        SpringApplication.run(HomeController.class);
    }

    @Controller
    @EnableAutoConfiguration
    public static class HomeController {
        @RequestMapping(value = "/addNumbers", method = RequestMethod.POST)
        @ResponseBody
        public AddNumbersResponse addNumbers(@RequestBody AddNumbersRequest request) {
            AddNumbersResponse response = new AddNumbersResponse();
            response.result = request.a + request.b;
            return response;
        }
    }

    public static class AddNumbersRequest {
        public int a;
        public int b;
    }

    public static class AddNumbersResponse {
        public int result;
    }
}
