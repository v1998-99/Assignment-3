package com.student.service;

import com.student.entity.Student;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
//@Service
public interface StudentService {

    public Mono<Student> saveStudent(Student student);
    public Flux<Student> findAllStudent();
    public Mono<Student> getById(String id);
    public Mono<Student> updateStudent(Student student , String id);
    public Mono<Void> deleteStudent(String id);
}
