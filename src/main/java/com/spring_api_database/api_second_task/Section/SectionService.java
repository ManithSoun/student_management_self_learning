package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Course.CourseRepo;
import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Exception.SectionHandlingError;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService {
    private final SectionRepo sectionRepo;
    private final CourseRepo courseRepo;
//    public SectionService(SectionRepo sectionRepo){
//        this.sectionRepo = sectionRepo;
//    }

    public Section saveSection(int courseId, String semester) {
        //find course by id
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new SectionHandlingError("The course not found"));
        //find how many of course that exist already so we can know what should be the next sectionCode this new course
        int count = sectionRepo.countByCourse_IdAndSemester(courseId, semester);
        //format of sectionCode 001, 002
        String sectionCode = String.format("%03d", count + 1);
        //Ex: COSC251-Fall2024-001
        String sectionName = course.getCourseCode() + "-" + semester + "-" + sectionCode;
        //Create new Section object
        Section section = new Section();
        section.setCourse(course);
        section.setSemester(semester);
        section.setSectionName(sectionName);
        return sectionRepo.save(section);
    }

    public void addMultiSection(List<Section> sections) {
        for (Section s : sections) {
            saveSection(s.getCourse().getId(), s.getSemester());
        }
    }

    @Transactional(readOnly = true)
    public List<SectionDto> getAllSectionsDto() {
        List<Section> sections = sectionRepo.findAllWithCourse();
        return sections.stream()
                .filter(section -> section.getCourse() != null)
                .map(section -> {
                    Course course = section.getCourse();
                    SimplifyCourseDto simplifyCourse = new SimplifyCourseDto(
                            course.getId(),
                            course.getCourseName(),
                            course.getCourseCode(),
                            course.getCredit()
                    );
                    return new SectionDto(
                            section.getId(),
                            section.getSemester(),
                            section.getSectionName(),
                            simplifyCourse
                    );
                })
                .toList();
    }

    public Section getSectionById(int id) {
        return sectionRepo.findById(id).orElseThrow(() -> new RuntimeException("Section not found"));
    }

    public Section deleteSection(int id) {
        Section section = sectionRepo.findById(id).orElseThrow(() -> new RuntimeException("Section not Found " + id));
        sectionRepo.deleteById(id);
        return section;
    }
//
//    public Section updateSection(UpdateSectionDto updateSectionDto) {
//        Section updateSection = sectionRepo.findById(updateSectionDto.getId()).orElse(null);
//        if (updateSection != null) {
//            updateSection.setSectionName(updateSection.getSectionName());
//            updateSection.setSemester(updateSection.getSemester());
//
//            Course course = courseRepo.findById(updateSectionDto.getCourseId()).orElse(null);
//            if (course != null) {
//                updateSection.setCourse(course);
//            }
//        }
//        return sectionRepo.save(updateSection);
//    }
}