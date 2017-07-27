package com.pizza.helper;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PizzaShort {

	Map<String, LocalDateTime> pizzaShort(MultipartFile file);

}
