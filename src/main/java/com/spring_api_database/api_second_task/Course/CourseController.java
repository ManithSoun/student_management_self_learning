package com.spring_api_database.api_second_task.Course;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
public class CourseController {
    private final CourseService courseService;

//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }

    @PostMapping("/saveCourse")
    public String saveCourses(@RequestBody Course course){
        courseService.addCourse(course);
        return "Saved!";
    }

    @PostMapping("/saveCourses")
    public String saveMultiCourse(@RequestBody List<Course> courses){
        courseService.addMultiCourse(courses);
        return "Saved!";
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(Course course){
        return courseService.getAllCourses();
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@RequestParam  int id){
        courseService.deleteCourse(id);
        return "Deleted";
    }
}
