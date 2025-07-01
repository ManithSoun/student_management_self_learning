package com.spring_api_database.api_second_task.Course;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

    Boolean existsByCourseCode(String courseCode);

}