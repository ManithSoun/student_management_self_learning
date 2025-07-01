package com.spring_api_database.api_second_task.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseDto {
    private Integer id;
    private String courseName;
    private String courseCode;
    private Integer credit;
}
