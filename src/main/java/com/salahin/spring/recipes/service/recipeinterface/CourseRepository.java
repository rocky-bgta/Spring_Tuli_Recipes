package com.salahin.spring.recipes.service.recipeinterface;

import com.salahin.spring.recipes.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> { }