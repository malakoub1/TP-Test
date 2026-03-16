package com.example.student_api.controller;


import jakarta.validation.Valid;
import com.example.student_api.dto.StudentRequestDTO;
import com.example.student_api.dto.StudentRespondDTO;
import com.example.student_api.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentRespondDTO addStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return studentService.addStudent(dto);
    }

    @GetMapping
    public List<StudentRespondDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentRespondDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentRespondDTO updateStudent(@PathVariable Long id,
                                            @Valid @RequestBody StudentRequestDTO dto) {
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}