package com.pizza.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.repository.PizzaOrder;
import com.pizza.repository.PizzaRepository;

/*
 *  For Future Use
 */

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository courseRepository;

    public List<PizzaOrder> getAllCourses(String topicId) {
        List<PizzaOrder> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public PizzaOrder getCourse(String id) {
        return courseRepository.findOne(id);
    }

    public void addCourse(PizzaOrder course) {
        courseRepository.save(course);
    }

    public void updateCourse(PizzaOrder course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
