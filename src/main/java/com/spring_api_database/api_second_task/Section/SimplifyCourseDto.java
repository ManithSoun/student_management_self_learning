package com.spring_api_database.api_second_task.Section;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplifyCourseDto {
    private Integer id;
    private String courseName;
    private String courseCode;
    private Integer credit;

}
