package com.spring_api_database.api_second_task.Student;

import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findByLastnameOrFirstname(String lastname, String firstname);

    @Query(value = "SELECT * FROM student_db ORDER BY st_mark DESC LIMIT 3", nativeQuery = true)
    List<Student> findTop3StudentsNative();

//    @Query(value = "SELECT * FROM student_db ORDER BY firstname OR lastname DESC LIMIT 5", nativeQuery = true)
//    List<Student> findByFirstLetter();

    @Query(value = "SELECT * FROM student_db WHERE firstname LIKE :prefix OR lastname LIKE :prefix LIMIT 5", nativeQuery = true)
    List<Student> findByFirstLetter(@Param("prefix") String prefix);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> deleteByAgeGreaterThan(int age);

    List<Student> findByOrderByFirstnameAsc();

    List<Student> findByOrderByAgeDesc();
}

