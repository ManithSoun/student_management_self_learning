package com.spring_api_database.api_second_task.Course;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring_api_database.api_second_task.Section.SectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {
    private Integer id;
    private String courseName;
    private String courseCode;
    private int credit;
    private List<SectionDto> sections;
}