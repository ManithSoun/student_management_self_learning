package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepo extends JpaRepository<Section, Integer> {
    Integer countByCourseIdAndSemester(Integer courseId, String semester);


}
