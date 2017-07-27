package com.pizza.repository;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 *  For Future Use
 *  Will get connected with embedded Derby DB
 */


@Entity
public class PizzaOrder {
    
	@Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime timeofOrder;

    
    public PizzaOrder() {
    }

    public PizzaOrder(String id, String name, String description, String topicId, LocalDateTime timeofOrder) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeofOrder = timeofOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public LocalDateTime getTimeofOrder() {
		return timeofOrder;
	}

	public void setTimeofOrder(LocalDateTime timeofOrder) {
		this.timeofOrder = timeofOrder;
	}

   
}
