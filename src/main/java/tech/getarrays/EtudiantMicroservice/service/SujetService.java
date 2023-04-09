package tech.getarrays.EtudiantMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EtudiantMicroservice.model.Sujet;
import tech.getarrays.EtudiantMicroservice.repo.SujetRepo;
import tech.getarrays.EtudiantMicroservice.exception.UserNotFoundException;



import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SujetService {
    private final SujetRepo sujetRepo;

    @Autowired
    public SujetService(SujetRepo sujetRepo) {
        this.sujetRepo = sujetRepo;
    }

    public Sujet addSujet(Sujet sujet) {
        sujet.setValide(false);
        sujet.setTaken(false);

        return sujetRepo.save(sujet);
    }

    public List<Sujet> findAllSujets() {
        return sujetRepo.findAll();
    }

    public Sujet updateSujet(Sujet sujet) {


        return sujetRepo.save(sujet);
    }

    public Sujet findSujetById(Long id) {
        return sujetRepo.findSujetById(id)
                .orElseThrow(() -> new UserNotFoundException("Sujet not found"));
    }

    public void deleteSujet(Long id){
        sujetRepo.deleteSujetById(id);
    }


}
