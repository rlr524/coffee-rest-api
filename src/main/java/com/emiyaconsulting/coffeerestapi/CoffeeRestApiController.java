package com.emiyaconsulting.coffeerestapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class CoffeeRestApiController {
    private List<Coffee> coffees = new ArrayList<>();

    public CoffeeRestApiController() {
        coffees.addAll(List.of(
                new Coffee("White Mocha"),
                new Coffee("Flat White"),
                new Coffee("Americano"),
                new Coffee("Peppermint Mocha")
        ));
    }

    @GetMapping()
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    @PostMapping()
    Coffee addCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> updateCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }

        return (coffeeIndex == -1) ?
                new ResponseEntity<>(addCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }

}
