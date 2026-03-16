package com.example.student_api.mapper;



import com.example.student_api.dto.FiliereReponseDTO;
import com.example.student_api.dto.FiliereRequestDTO;
import com.example.student_api.entity.Filiere;
import org.springframework.stereotype.Component;

@Component //detectable par spring automatiquement , dont elle le gere comme bean
public class FiliereMapper {

    //utilise lors d une requete POST ou PUT
    public Filiere toEntity(FiliereRequestDTO dto) {

        Filiere filiere = new Filiere();
        filiere.setName(dto.name());
        return filiere;
    }

    // utilisé pour envoyer une reponse JSON au client a travers API
    public FiliereReponseDTO toResponseDTO(Filiere filiere) {
        return new FiliereReponseDTO(
                filiere.getId(),
                filiere.getName()
        );
    }

    public void updateEntityFromDTO(FiliereRequestDTO dto, Filiere filiere) {
       filiere.setName(dto.name());
    }
}