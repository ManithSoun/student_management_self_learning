package com.spring_api_database.api_second_task.Section;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring_api_database.api_second_task.Course.CourseDto;
import com.spring_api_database.api_second_task.Entity.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionDto {
    private Integer id;
    private String semester;
    private String sectionName;
    private SimplifyCourseDto course;

    public SectionDto(Section section) {
        this.id = section.getId();
        this.semester = section.getSemester();
        this.sectionName = section.getSectionName();
        this.course = new SimplifyCourseDto(
                section.getCourse().getId(),
                section.getCourse().getCourseName(),
                section.getCourse().getCourseCode(),
                section.getCourse().getCredit()
        );
    }
}
