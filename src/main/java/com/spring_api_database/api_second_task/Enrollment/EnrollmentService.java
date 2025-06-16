package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import com.spring_api_database.api_second_task.Section.SectionRepo;
import com.spring_api_database.api_second_task.Student.StudentRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EnrollmentService {
    private final EnrollmentRepo enrollmentRepo;
    private final SectionRepo sectionRepo;
    private final StudentRepo studentRepo;

    public Enrollment saveStudentEnrollment(int studentId, int sectionId){
//        log.info("studentId {}", studentId);
//        log.info("sectionId {}", sectionId);
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student is not found"));
        Section section = sectionRepo.findById(sectionId).orElseThrow(()-> new RuntimeException("Section is not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setSection(section);

        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getStudentEnrollment(){
        return enrollmentRepo.findAll();
    }

    public List<Student> findStudentInSection(int sectionId){
        return enrollmentRepo.findStudentsBySectionId(sectionId);
    }
}
