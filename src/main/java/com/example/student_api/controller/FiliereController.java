package com.example.student_api.controller;

import com.example.student_api.dto.FiliereReponseDTO;
import com.example.student_api.dto.FiliereRequestDTO;
import com.example.student_api.service.FiliereService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FiliereReponseDTO addFiliere(@Valid @RequestBody FiliereRequestDTO dto) {
        return filiereService.addFiliere(dto);
    }

    @GetMapping
    public List<FiliereReponseDTO> getAllFiliere() {
        return filiereService.getAllFiliere();
    }

    @GetMapping("/{id}")
    public FiliereReponseDTO getFiliereById(@PathVariable Long id) {
        return filiereService.getFiliereById(id);
    }

    @PutMapping("/{id}")
    public FiliereReponseDTO updateFiliere(@PathVariable Long id,
                                           @Valid @RequestBody FiliereRequestDTO dto) {
        return filiereService.updateFiliere(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFiliere(@PathVariable Long id) {
        filiereService.deletefiliere(id);
    }
}