package com.spring_api_database.api_second_task.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String grade;
}
