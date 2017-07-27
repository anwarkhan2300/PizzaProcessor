 package com.pizza.repository;

import org.springframework.data.repository.CrudRepository;

/*
 *  For Future Use
 *  Will get connected with embedded Derby DB
 */


public interface PizzaRepository extends CrudRepository<PizzaOrder, String> {
}