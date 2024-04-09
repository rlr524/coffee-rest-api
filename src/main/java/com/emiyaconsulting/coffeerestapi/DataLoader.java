package com.emiyaconsulting.coffeerestapi;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        coffeeRepository.saveAll(List.of(
                new Coffee("White Mocha"),
                new Coffee("Flat White"),
                new Coffee("Americano"),
                new Coffee("Peppermint Mocha")
        ));
    }
}
