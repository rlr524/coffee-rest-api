package com.emiyaconsulting.coffeerestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    // "Mirage" is a default value for cases in which "greeting-name" isn't defined in app config.
//    @Value("${greeting-name: Mirage}")
//    private String name;
//
//    @Value("${greeting-coffee: ${greeting-name} is drinking a flat white}")
//    private String coffee;

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    String getGreeting() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    String getNameAndCoffee() {
        return greeting.getCoffee();
    }
}
