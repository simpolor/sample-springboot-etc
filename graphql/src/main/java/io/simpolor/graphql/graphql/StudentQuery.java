package io.simpolor.graphql.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.simpolor.graphql.repository.StudentRepository;
import io.simpolor.graphql.repository.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentQuery implements GraphQLQueryResolver {

    private final StudentRepository studentRepository;

    public long countStudent(){
        return studentRepository.count();
    }

    public Iterable<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long studentId){

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if(!optionalStudent.isPresent()){
            throw new IllegalArgumentException("studentId : "+studentId);
        }

        return optionalStudent.get();
    }

}
