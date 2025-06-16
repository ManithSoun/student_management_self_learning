package com.spring_api_database.api_second_task.Student;

import com.spring_api_database.api_second_task.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void saveInfo(Student student){
        studentRepo.save(student);
    }
    public List<Student> getAllInfo(){
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void addMultiStudents(List<Student> students){
        studentRepo.saveAll(students);
    }

    public List<Student> getStudentByLastnameOrFirstname(String lastname, String firstname) {
        return studentRepo.findByLastnameOrFirstname(lastname, firstname);
    }

    public String deleteStudent(int id){
        studentRepo.deleteById(id);
        return "deleted" + id;
    }

    public void deleteAllStudent(){
        studentRepo.deleteAll();

    }
//Another way of writing delete method (good with frontend)
//    public Student delete(int id) {
//        Student student = studentRepo.findById(id).orElse(null);
//        if (student != null) {
//            studentRepo.deleteById(id);
//        }
//        return student;
//    }

    public Student updateInfo(Student student){
        Student updateStudent = studentRepo.findById(student.getId()).orElse(null);
        if (updateStudent != null){
            updateStudent.setGrade(student.getGrade());
            updateStudent.setFirstname(student.getFirstname());
            updateStudent.setLastname(student.getLastname());
            studentRepo.save(updateStudent);
            return updateStudent;
        }
        return null;
    }

    public List<Student> getTop3StudentsByMark(){
        return studentRepo.findTop3StudentsNative();
    }

    public List<Student> getStudentByPrefix(String prefix){
        return studentRepo.findByFirstLetter(prefix +"%");
    }

    public List<Student> getStudentByAgeGreaterThan(int age){
        return studentRepo.findByAgeGreaterThan(age);
    }

    public List<Student> deleteStudentByAgeGreaterThan(int age){
        return studentRepo.deleteByAgeGreaterThan(age);
    }

    public List<Student> getStudentBySortingNameAsc(){
        return studentRepo.findByOrderByFirstnameAsc();
    }

    public List<Student> getStudentByShortingAgeDesc(){
        return studentRepo.findByOrderByAgeDesc();
    }
}