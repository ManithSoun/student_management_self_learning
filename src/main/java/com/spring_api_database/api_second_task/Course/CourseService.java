package com.spring_api_database.api_second_task.Course;
import com.spring_api_database.api_second_task.Enrollment.UpdateEnrollmentDto;
import com.spring_api_database.api_second_task.Entity.Course;
import com.spring_api_database.api_second_task.Entity.Enrollment;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import com.spring_api_database.api_second_task.Exception.CourseHandlingError;
import com.spring_api_database.api_second_task.Section.SectionDto;
import com.spring_api_database.api_second_task.Section.SimplifyCourseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private SimplifyCourseDto course;


    public CourseService(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }

    public Course addCourse(Course course){
        if (courseRepo.existsByCourseCode(course.getCourseCode())){
            throw new IllegalArgumentException(
                    String.format("The course '%s' already exists", course.getCourseCode())
            );
        }
        return courseRepo.save(course);
    }


    public void addMultiCourse(List<Course> courses){
        courseRepo.saveAll(courses);
    }

//    public Optional<Course> getCourseById(int id){
//        return courseRepo.findById(id);
//    }
    public Optional<Course> getCourseById(int id){
        return courseRepo.findById(id);
    }


    public void deleteCourse(Integer id){
        courseRepo.deleteById(id);
    }
//    public CourseDto deleteCourse(Integer id){
//        Course course = courseRepo.findById(id)
//                .orElseThrow(() -> new CourseHandlingError("No course found"));
//
//        List<SectionDto> sectionDto = course.getSections().stream().map(section -> {
//            SectionDto sDto = new SectionDto();
//            sDto.setId(section.getId());
//            sDto.setSemester(section.getSemester());
//            sDto.setSectionName(section.getSectionName());
//            return sDto;
//        }).toList();
//
//        courseRepo.delete(course);
//
//        return new CourseDto(
//                course.getId(),
//                course.getCourseName(),
//                course.getCourseCode(),
//                course.getCredit(),
//                sectionDto
//        );
//    }

    //    public List<Course> getAllCourses(){
//        return courseRepo.findAll();
//    }
    public List<CourseDto> getAllCourseDTOs() {
        return courseRepo.findAll().stream().map(course -> {
            CourseDto dto = new CourseDto();
            dto.setId(course.getId());
            dto.setCourseName(course.getCourseName());
            dto.setCourseCode(course.getCourseCode());
            dto.setCredit(course.getCredit());

            List<SectionDto> sectionDto = course.getSections().stream().map(section -> {
                SectionDto sDto = new SectionDto();
                sDto.setId(section.getId());
                sDto.setSemester(section.getSemester());
                sDto.setSectionName(section.getSectionName());
//                sDto.setCourse(null);
                return sDto;
            }).toList();

            dto.setSections(sectionDto);
            return dto;
        }).toList();
    }

    public Course updateCourse(CourseDto courseDto){
        Course updateCourse = courseRepo.findById(courseDto.getId()).orElse(null);
        if (updateCourse != null){
            updateCourse.setCourseName(courseDto.getCourseName());
            updateCourse.setCourseCode(courseDto.getCourseCode());
            updateCourse.setCredit(courseDto.getCredit());
            courseRepo.save(updateCourse);
        }
        return updateCourse;
    }





}


