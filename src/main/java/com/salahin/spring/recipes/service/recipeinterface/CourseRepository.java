package com.salahin.spring.recipes.service.recipeinterface;

import com.salahin.spring.recipes.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> { }