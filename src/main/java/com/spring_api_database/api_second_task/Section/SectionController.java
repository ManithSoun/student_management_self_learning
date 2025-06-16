package com.spring_api_database.api_second_task.Section;

import com.spring_api_database.api_second_task.Entity.Section;
import com.spring_api_database.api_second_task.Entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SectionController {
    private final SectionService sectionService;

//    public SectionController(SectionService sectionService){
//        this.sectionService = sectionService;
//    }

    @PostMapping("/saveSection")
    public String saveSection(@RequestBody Section section){
        sectionService.addSection(section.getCourseId(), section.getSemester());
        return "Saved!";
    }
//
//    @PostMapping("/saveMultiSections")
//    public String saveMultiSections(@RequestBody List<Section> sections){
//        return sectionService.addMultiSection(section.getCourseId(), section.getSemester());
//    }

    @GetMapping("/sections")
    public List<Section> getAllSection(){
        return sectionService.getAllSection();
    }

    @GetMapping("/section/{id}")
    public Section getSectionById(@PathVariable int id){
        return sectionService.getSectionById(id);
    }

}
