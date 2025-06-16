package com.spring_api_database.api_second_task.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "Student_db")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "grade")
    private String grade;

    @Column(name= "firstname")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "AGE")
    private int age;
}
