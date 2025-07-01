package com.spring_api_database.api_second_task.Student;

import com.spring_api_database.api_second_task.Entity.Student;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;


    @GetMapping(value = "")
//    @CrossOrigin(origins = "http://localhost:3000")
    public List<Student> getInfo(){
        return studentService.getAllInfo();
    }

    @GetMapping("/{id}")
    public Student getInfoById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

//    @GetMapping("/{lastname} | {firstname}")
    @GetMapping("/search")
    public List<Student> searchStudents(
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String grade) {
        return studentService.getStudentByLastnameOrFirstnameOrAgeOrGrade(lastname, firstname, age, grade);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> postInfo(@RequestBody Student student){
        Student saveStudent = studentService.saveInfo(student);
        return ResponseEntity.ok(saveStudent);
    }

    @PostMapping("/addMultiStudent")
    public String postMultiInfo(@RequestBody List<Student> students){
        studentService.addMultiStudents(students);
        return "Saved!";
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> putInfo(@RequestBody Student student){
        Student updateStudent = studentService.updateInfo(student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/delete/{id}")
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


