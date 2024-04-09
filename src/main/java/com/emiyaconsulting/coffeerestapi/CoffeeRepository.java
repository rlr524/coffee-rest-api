package com.emiyaconsulting.coffeerestapi;

import org.springframework.data.repository.CrudRepository;

// The two types defined on CrudRepository are the object type to store and the type of its UID.
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
