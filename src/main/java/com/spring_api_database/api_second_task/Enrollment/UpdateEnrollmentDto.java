package com.spring_api_database.api_second_task.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEnrollmentDto {
    private Integer id;
    private Integer studentId;
    private Integer sectionId;
}
