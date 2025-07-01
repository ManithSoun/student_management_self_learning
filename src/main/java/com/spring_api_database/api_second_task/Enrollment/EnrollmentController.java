package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/saveEnrollment")
    public Enrollment addStudentEnrollment(@RequestParam Integer studentId, @RequestParam Integer sectionId) {
        return enrollmentService.saveStudentEnrollment(studentId, sectionId);
    }

    @GetMapping("/enrollments")
    public List<EnrollmentDto> getEnrollments() {
        return enrollmentService.getStudentEnrollmentDto();
    }

    //@GetMapping("/enrollment/sectionId{sectionId}/student")
    //@GetMapping("/enrollment/students/section/{sectionId}")
    @GetMapping("/enrollment/section/{sectionId}/students")
    public List<Student> findStudentBySectionId(@PathVariable Integer sectionId) {
        return enrollmentService.findStudentInSection(sectionId);
    }

    //@GetMapping("/enrollment/sections")
    //@GetMapping("/enrollment/sections/student/{studentId}")
    @GetMapping("/enrollment/student/{studentId}/sections")
    public List<Section> findSectionsOfStudent(@PathVariable Integer studentId) {
        return enrollmentService.findSectionsOfStudent(studentId);
    }

    @DeleteMapping("enrollment/delete/{id}")
    public Enrollment deleteStudentEnrollment(@PathVariable Integer id){
        return enrollmentService.deleteStudentEnrollment(id);
    }

    @PutMapping("enrollment/update")
    public ResponseEntity<Enrollment> updateInfo(@RequestBody UpdateEnrollmentDto updateEnrollmentDto)
    {
        Enrollment updateEnrollment = enrollmentService.updateStudentEnrollment(updateEnrollmentDto);
        return ResponseEntity.ok(updateEnrollment);
    }
}
