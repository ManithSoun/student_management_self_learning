package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import com.spring_api_database.api_second_task.Exception.EnrollmentHandlingError;
import com.spring_api_database.api_second_task.Section.SectionDto;
import com.spring_api_database.api_second_task.Section.SectionRepo;
import com.spring_api_database.api_second_task.Section.SimplifyCourseDto;
import com.spring_api_database.api_second_task.Student.StudentDto;
import com.spring_api_database.api_second_task.Student.StudentRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> errors = new ArrayList<>();

        Student student = studentRepo.findById(studentId).orElse(null);
        if (student == null) {
            errors.add("Student not found");
        }
        Section section = sectionRepo.findById(sectionId).orElse(null);
        if (section == null) {
            errors.add("Section not found");
        }

        if (!errors.isEmpty()) {
            throw new EnrollmentHandlingError(String.join("; ", errors)); // Send all errors together
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setSection(section);

        return enrollmentRepo.save(enrollment);
    }
//    public List<Enrollment> getStudentEnrollment(){
//        return enrollmentRepo.findAll();
//    }
public List<EnrollmentDto> getStudentEnrollmentDto() {
    return enrollmentRepo.findAll().stream().map(enrollment -> {
        Section section = enrollment.getSection();
        Student student = enrollment.getStudent();
        Course course = section.getCourse();
        // Create a simplified Course DTO
        SimplifyCourseDto courseDto = new SimplifyCourseDto(
                course.getId(),
                course.getCourseName(),
                course.getCourseCode(),
                course.getCredit()
        );
        // Create a simplified Section DTO (without nested course list!)
        SectionDto sectionDto = new SectionDto(
                section.getId(),
                section.getSemester(),
                section.getSectionName(),
                courseDto
        );

        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getAge(),
                student.getGrade()
        );
        // Build the enrollment DTO
        EnrollmentDto dto = new EnrollmentDto();
        dto.setId(enrollment.getId());
        dto.setSection(sectionDto);
        dto.setStudent(studentDto);

        return dto;
    }).collect(Collectors.toList());
}

    public List<Student> findStudentInSection(int sectionId){
        return enrollmentRepo.findStudentsBySectionId(sectionId);
    }

    public List<Section> findSectionsOfStudent(Integer studentId){
        return enrollmentRepo.findSectionsByStudentId(studentId);
    }

    public Enrollment deleteStudentEnrollment(int id){
        Enrollment enrollment = enrollmentRepo.findById(id).orElseThrow(() -> new EnrollmentHandlingError("Enrollment not Found"));
        enrollmentRepo.deleteById(id);
        return enrollment;
    }

    public Enrollment updateStudentEnrollment(UpdateEnrollmentDto updateEnrollmentDto) {
        Enrollment enrollment = enrollmentRepo.findById(updateEnrollmentDto.getId()).orElse(null);
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment not found");
        }

        Student student = studentRepo.findById(updateEnrollmentDto.getStudentId()).orElse(null);
        Section section = sectionRepo.findById(updateEnrollmentDto.getSectionId()).orElse(null);

        if (student == null || section == null) {
            throw new IllegalArgumentException("Student or Section not found");
        }

        enrollment.setStudent(student);
        enrollment.setSection(section);

        return enrollmentRepo.save(enrollment);
    }


}
