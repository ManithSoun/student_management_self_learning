package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

//    @PostMapping("/saveEnrollment")
//    public String addStudentEnrollment(@RequestParam CreateEnrollmentDto studentId, CreateEnrollmentDto sectionId){
//
//        enrollmentService.saveStudentEnrollment(createEnrollmentDto.studentId, createEnrollmentDto.sectionId);
//        return "saved!";
//    }

    @PostMapping("/saveEnrollment")
    public Enrollment addStudentEnrollment(@RequestParam Integer studentId, @RequestParam Integer sectionId) {

        return enrollmentService.saveStudentEnrollment(studentId, sectionId);
    }

    @GetMapping("/enrollment/{sectionId}/student")
    public List<Student> findStudentBySectionId(@PathVariable Integer sectionId) {
        return enrollmentService.findStudentInSection(sectionId);
    }


    @GetMapping("/enrollment")
    public List<Enrollment> getStudentEnrollment(){
        return enrollmentService.getStudentEnrollment();
    }
}
