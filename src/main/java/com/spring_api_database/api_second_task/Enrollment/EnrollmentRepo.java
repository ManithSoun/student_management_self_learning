package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
//    @Query(value = "SELECT * FROM student_db WHERE firstname LIKE :prefix OR lastname LIKE :prefix LIMIT 5", nativeQuery = true)
//    List<Student> findByFirstLetter(@Param("prefix") String prefix);
//    @Query(value = "SELECT * FROM enrollment_db WHERE section.courseId")
//    List<Enrollment> findStudentByCourseId(@Param("courseId") Integer courseId);

    @Query("SELECT e.student FROM Enrollment e WHERE e.section.id = :sectionId")
    List<Student> findStudentsBySectionId(@Param("sectionId") Integer sectionId);


}

