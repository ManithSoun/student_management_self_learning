package com.spring_api_database.api_second_task.Course;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Exception.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.ColorUIResource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
public class CourseController {
    private final CourseService courseService;

//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }

//    @PostMapping(
//            value = "/saveCourse"
//    )
//    public ApiResponse<?> saveCourse(@RequestBody Course course) {
//        courseService.addCourse(course);
//        return  new ApiResponse<>(
//                "Created",
//                "Created Course successfully",
//                "saved",
//                null
//        );
//    }
    @PostMapping("/saveCourse")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course created = courseService.addCourse(course);
        return ResponseEntity.ok(created);
    }

    @PostMapping("/saveCourses")
    public String saveMultiCourse(@RequestBody List<Course> courses) {
        courseService.addMultiCourse(courses);
        return "Saved!";
    }

    @GetMapping("/courses")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourseDTOs();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/course/update")
    public ResponseEntity<Course> updateCourse(@RequestBody CourseDto courseDto){
        Course updateCourse = courseService.updateCourse(courseDto);
        return ResponseEntity.ok(updateCourse);
    }

}
