package me.loki2302.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public String hello() {
        return String.format(
                "There are %d persons in the repository",
                personRepository.count());
    }
}
