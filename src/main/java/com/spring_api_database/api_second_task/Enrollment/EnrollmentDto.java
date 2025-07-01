package com.spring_api_database.api_second_task.Enrollment;

import com.spring_api_database.api_second_task.Entity.Student;
import com.spring_api_database.api_second_task.Section.SectionDto;
import com.spring_api_database.api_second_task.Student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentDto {
    private Integer id;
    private SectionDto section;
    private StudentDto student;
}

