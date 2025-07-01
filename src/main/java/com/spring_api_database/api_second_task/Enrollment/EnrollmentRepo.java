package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
    @Query("SELECT e.student FROM Enrollment e WHERE e.section.id = :sectionId")
    List<Student> findStudentsBySectionId(@Param("sectionId") Integer sectionId);

    @Query("SELECT e.section FROM Enrollment e WHERE e.student.id = :studentId")
    List<Section> findSectionsByStudentId(@Param("studentId") Integer studentId);


}

