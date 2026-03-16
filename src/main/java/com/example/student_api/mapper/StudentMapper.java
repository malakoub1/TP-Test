package com.example.student_api.mapper;


import com.example.student_api.dto.StudentRequestDTO;
import com.example.student_api.dto.StudentRespondDTO;
import com.example.student_api.entity.Student;
import org.springframework.stereotype.Component;

@Component //detectable par spring automatiquement , dont elle le gere comme bean
public class StudentMapper {

    //utilise lors d une requete POST ou PUT
    public Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setMajor(dto.major());
        student.setAge(dto.age());
        return student;
    }

    // utilisé pour envoyer une reponse JSON au client a travers API
    public StudentRespondDTO toResponseDTO(Student student) {
        return new StudentRespondDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                student.getAge()
        );
    }

    public void updateEntityFromDTO(StudentRequestDTO dto, Student student) {
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setMajor(dto.major());
        student.setAge(dto.age());
    }
}