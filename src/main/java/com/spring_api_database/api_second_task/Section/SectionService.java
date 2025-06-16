package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Course.CourseRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public class SectionService {
    private final SectionRepo sectionRepo;
    private final CourseRepo courseRepo;
//    public SectionService(SectionRepo sectionRepo){
//        this.sectionRepo = sectionRepo;
//    }

    public Section addSection(int courseId, String semester){
        //find course by id
        Course course= courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("The course not found"));
        //find how many of course that exist already so we can know what should be the next sectionCode this new course
        int count = sectionRepo.countByCourseIdAndSemester(courseId, semester);
        //format of sectionCode 001, 002
        String sectionCode = String.format("%03d", count + 1);
        //Ex: COSC251-Fall2024-001
        String sectionName = course.getCourseCode() + "-" + semester + "-" + sectionCode;
        //Create new Section object
        Section section = new Section();
        section.setCourseId(courseId);
        section.setSemester(semester);
        section.setSectionName(sectionName);
        return sectionRepo.save(section);
    }

//    public List<Section> addMultiSection(int courseId, String semester, int n){
//        List<Section> addSections = new ArrayList<>();
//
//        for (Section section: sections){
//            Course course= courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("The course not found"));
//
//            int count = sectionRepo.countByCourseIdAndSemester(courseId, semester);
//            String sectionCode = String.format("%03d", count + 1);
//            String sectionName = course.getCourseCode() + "-" + section.semester + "-" + sectionCode;
//
//            Section newSection = new Section();
//            newSection.setCourseId(courseId);
//            newSection.setSemester(semester);
//            newSection.setSectionName(sectionName);
//            addSections.add(newSection);
//        }
//
//        return sectionRepo.saveAll(addSections);
//    }




    public void addMultiSection(List<Section> sections){
        sectionRepo.saveAll(sections);
    }

    public List<Section> getAllSection(){
        return sectionRepo.findAll();
    }

    public Section getSectionById(int id) {
        return sectionRepo.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
    }
}

