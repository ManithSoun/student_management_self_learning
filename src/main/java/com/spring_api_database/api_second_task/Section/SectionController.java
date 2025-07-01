package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Course.CourseService;
import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sections")
public class SectionController {
    private final SectionService sectionService;
    private final CourseService courseService;
//    public SectionController(SectionService sectionService){
//        this.sectionService = sectionService;
//    }

    @PostMapping("/new")
    public ResponseEntity<Section> saveSection(@RequestBody CreateSectionDto section){
        Section created = sectionService.saveSection(section.getCourseId(), section.getSemester());
        return ResponseEntity.ok(created);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/saveMultiSections")
//    public String saveMultiSections(@RequestBody List<Section> sections){
//        return sectionService.addMultiSection(section.getCourseId(), section.getSemester());
//    }

    @GetMapping("")
    public List<SectionDto>  getAllSection(){
        return sectionService.getAllSectionsDto();
    }

    @GetMapping("/{id}")
    public SectionDto getSectionById(@PathVariable int id){
        Section section = sectionService.getSectionById(id);
        return new SectionDto(section);
    }

//    @DeleteMapping("/delete/{id}")
//    public Section deleteSection(@PathVariable int id){
//        return sectionService.deleteSection(id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable int id){
        sectionService.deleteSection(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/update")
//    public ResponseEntity<Section> updateSection(@RequestBody UpdateSectionDto updateSectionDto){
//        Section updateSection = sectionService.updateSection(updateSectionDto);
//        return ResponseEntity.ok(updateSection);
//    }
}