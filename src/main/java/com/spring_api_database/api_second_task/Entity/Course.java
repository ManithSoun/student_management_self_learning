package com.spring_api_database.api_second_task.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "course_db")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String courseName;

    @Column
    private String courseCode;

    @Column
    private int credit;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private List<Section> sections;

}
