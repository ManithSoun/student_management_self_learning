package com.spring_api_database.api_second_task.Course;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }

    public void addCourse(Course course){
        courseRepo.save(course);
    }

    public void addMultiCourse(List<Course> courses){
        courseRepo.saveAll(courses);
    }

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int id){
        return courseRepo.findById(id);
    }

    public void deleteCourse(int id){
        courseRepo.deleteById(id);
    }
}

