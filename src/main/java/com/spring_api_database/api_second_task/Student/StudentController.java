package com.spring_api_database.api_second_task.Student;

import com.spring_api_database.api_second_task.Entity.Student;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/getStudent")
    public List<Student> getInfo(Student student){
        return studentService.getAllInfo();
    }

    @GetMapping("/getStudent/{id}")
    public Student getInfoById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

//    @GetMapping("/{lastname} | {firstname}")
    @GetMapping("/getStudentByName")
    public List<Student> getInfoByLastnameOrFirstname(
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String firstname) {
        return studentService.getStudentByLastnameOrFirstname(lastname, firstname);
    }

    @PostMapping("/addStudent")
    public String postInfo(@RequestBody Student student){
        studentService.saveInfo(student);
        return "Saved!";
    }

    @PostMapping("/addMultiStudent")
    public String postMultiInfo(@RequestBody List<Student> students){
        studentService.addMultiStudents(students);
        return "Saved!";
    }

    @PutMapping("/updateStudent")
    public String putInfo(@RequestBody Student student){
        studentService.updateInfo(student);
        return "Updated!";
    }

    @DeleteMapping("/delete{id}")
    public String deleteInfo(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllStudents(){
        studentService.deleteAllStudent();
        return "DELETED";
    }

    @GetMapping("/top3")
    public List<Student> getTop3Students(){
        return studentService.getTop3StudentsByMark();
    }

    @GetMapping("/getStudentByPrefix")
    public List<Student> getStudentByPrefix(@RequestParam String prefix){
        return studentService.getStudentByPrefix(prefix);
    }

    @GetMapping("/getStudentGreaterThan")
    public List<Student> getStudentByAgeGreaterThan(int age){
        return studentService.getStudentByAgeGreaterThan(age);
    }

    @DeleteMapping("/deleteStudentByAgeGreaterThan")
    public List<Student> deleteStudentByAgeGreaterThan(int age){
        return studentService.deleteStudentByAgeGreaterThan(age);
    }

    @GetMapping("/getStudent/sorted/name")
    public List<Student> getStudentBySortingNameAsc(){
        return studentService.getStudentBySortingNameAsc();
    }

    @GetMapping("/getStudent/sorted/age")
    public List<Student> getStudentBySortingAgeDesc(){
        return studentService.getStudentByShortingAgeDesc();
    }

}


