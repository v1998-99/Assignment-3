package com.student.serviceimpl;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public Mono<Student> saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Flux<Student> findAllStudent() {

            return studentRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Student> getById(String id) {
        return studentRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Student> updateStudent(Student student, String id) {
        return studentRepository.save(student);
    }

    @Override
    public Mono<Void> deleteStudent(String id) {
        return studentRepository.deleteById(id);
    }
}
