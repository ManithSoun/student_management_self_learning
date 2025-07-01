package com.spring_api_database.api_second_task.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "section_db")
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column
//    private int sectionCode;

    @Column
    private String semester;

    @Column
    private String sectionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

//    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Enrollment> enrollments;
}

