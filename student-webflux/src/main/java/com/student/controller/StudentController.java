package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/savestudent")
    public Mono<Student> saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);

    }
    @GetMapping("/allstudent")
    public Flux<Student> getAllStudents(){
        return studentService.findAllStudent();
    }
    @GetMapping("/student/{id}")
    public Mono<Student> getStudentById(@PathVariable("id") String id){
        Mono<Student> student= studentService.getById(id);
       return student;
  }
    @PutMapping("/update/{id}")
    public Mono<Student> updateById(@PathVariable("id") String id, @RequestBody Student student) {
        System.out.println("::Update the Student record::");
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("delete/{id}")
    public Mono<String> deleteStudent(@PathVariable("id") String id){
        studentService.deleteStudent(id);
        return Mono.just("Student with id: " +id+ " deleted !");
    }

}