package tech.getarrays.EtudiantMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EtudiantMicroservice.exception.UserNotFoundException;
import tech.getarrays.EtudiantMicroservice.model.Postulation;
import tech.getarrays.EtudiantMicroservice.model.Sujet;
import tech.getarrays.EtudiantMicroservice.repo.PostulationRepo;
import tech.getarrays.EtudiantMicroservice.repo.SujetRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostulationService {
    private final PostulationRepo postulationRepo;
    private final SujetRepo sujetRepo;



    @Autowired
    public PostulationService(PostulationRepo postulationRepo,SujetRepo sujetRepo) {
        this.postulationRepo = postulationRepo;
        this.sujetRepo = sujetRepo;
    }

    public Postulation addPostulation(Postulation postulation) {
        postulation.setValide(false);
        return postulationRepo.save(postulation);
    }

    public List<Postulation> findAllPostulations() {
        return postulationRepo.findAll();
    }

    public Postulation updatePostulation(Postulation postulation) {
        return postulationRepo.save(postulation);
    }

    public void validerPostulation(Long id){
        Postulation postulation;
        postulation=postulationRepo.findPostulationById(id)
                .orElseThrow(() -> new UserNotFoundException("Postulation not found"));

        postulation.setValide(true);
        Sujet sujet;
        Long IDsuj=postulation.getIdSujet();
        sujet=sujetRepo.findSujetById(IDsuj)
                .orElseThrow(() -> new UserNotFoundException("Sujet not found"));
        sujet.setTaken(true);

    }

    public void deletePostulation(Long id){
        postulationRepo.deletePostulationById(id);
    }
}
