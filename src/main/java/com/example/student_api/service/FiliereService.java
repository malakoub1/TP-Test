package com.example.student_api.service;

import com.example.student_api.dto.FiliereReponseDTO;
import com.example.student_api.dto.FiliereRequestDTO;
import com.example.student_api.dto.StudentRequestDTO;
import com.example.student_api.dto.StudentRespondDTO;
import com.example.student_api.entity.Filiere;
import com.example.student_api.entity.Student;
import com.example.student_api.exception.ResourceNotFoundException;
import com.example.student_api.mapper.FiliereMapper;
import com.example.student_api.mapper.StudentMapper;
import com.example.student_api.repository.FiliereRepository;
import com.example.student_api.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //indique que cette classe appartient a la couche metier
public class FiliereService {

    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    public FiliereService(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    public FiliereReponseDTO addFiliere(FiliereRequestDTO dto) {
        Filiere filiere = filiereMapper.toEntity(dto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.toResponseDTO(savedFiliere);
    }

    //recuperer tous les etudiants
    public List<FiliereReponseDTO> getAllFiliere() {
        return filiereRepository.findAll()
                .stream()
                .map(filiereMapper::toResponseDTO)
                .toList();
    }

    //recherche d un etudiant par id
    public FiliereReponseDTO getFiliereById(Long id) {
        Filiere  filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filiere introuvable avec l'id : " + id));

        return filiereMapper.toResponseDTO(filiere);
    }

    //met a jour les champs a partir du DTO
    public FiliereReponseDTO updateFiliere(Long id, FiliereRequestDTO dto) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" filiere introuvable avec l'id : " + id));

        filiereMapper.updateEntityFromDTO(dto, filiere);
        Filiere updatedFiliere = filiereRepository.save(filiere);

        return filiereMapper.toResponseDTO(updatedFiliere);
    }


    public void deletefiliere(Long id) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("filiere introuvable avec l'id : " + id));

        filiereRepository.delete(filiere);
    }
}