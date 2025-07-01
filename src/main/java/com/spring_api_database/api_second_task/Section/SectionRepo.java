package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SectionRepo extends JpaRepository<Section, Integer> {
    Integer countByCourse_IdAndSemester(Integer courseId, String semester);

    @Query("SELECT s FROM Section s JOIN FETCH s.course")
    List<Section> findAllWithCourse();


}
