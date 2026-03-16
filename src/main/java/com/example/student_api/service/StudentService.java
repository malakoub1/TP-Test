package com.example.student_api.service;

import com.example.student_api.dto.StudentRequestDTO;
import com.example.student_api.dto.StudentRespondDTO;
import com.example.student_api.entity.Student;
import com.example.student_api.exception.ResourceNotFoundException;
import com.example.student_api.mapper.StudentMapper;
import com.example.student_api.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //indique que cette classe appartient a la couche metier
public class StudentService {

    private final StudentRepo studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentRespondDTO addStudent(StudentRequestDTO dto) {
        Student student = studentMapper.toEntity(dto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    //recuperer tous les etudiants
    public List<StudentRespondDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponseDTO)
                .toList();
    }

    //recherche d un etudiant par id
    public StudentRespondDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        return studentMapper.toResponseDTO(student);
    }

    //met a jour les champs a partir du DTO
    public StudentRespondDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        studentMapper.updateEntityFromDTO(dto, student);
        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(updatedStudent);
    }

    //verifier l'existance de l etudiant par son id puis le supprimer
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        studentRepository.delete(student);
    }
}