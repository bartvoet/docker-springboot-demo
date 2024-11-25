package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloRepo helloRepo;

    @GetMapping("test")
    public String hello() {
        return "hello";
    }

    @GetMapping("sayhello")
    @Transactional
    public String sayhello(@RequestParam String hello) {
        helloRepo.save(new HelloMessage(hello));
        return "hello";
    }

    @GetMapping("listhellos")
    @Transactional
    public String listhellos() {
        return helloRepo.findAll()
                .stream().map(HelloMessage::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
