package tech.getarrays.EtudiantMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;
import tech.getarrays.EtudiantMicroservice.model.Postulation;
import tech.getarrays.EtudiantMicroservice.repo.EtudiantRepo;
import tech.getarrays.EtudiantMicroservice.repo.PostulationRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostulationService {
    private final PostulationRepo postulationRepo;
    private final EtudiantService etudiantService;



    @Autowired
    public PostulationService(PostulationRepo postulationRepo,EtudiantService etudiantService) {
        this.postulationRepo = postulationRepo;
        this.etudiantService=etudiantService;
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

    public List<Etudiant> findAllPostulationsByIdSujet(Long idSuejt) {
        List<Postulation> L=postulationRepo.FindEtudiantByIdSujet(idSuejt);
        List <Etudiant> resulat = new ArrayList<>();
        for (int i = 0; i < L.size(); i++) {
            Postulation postulation = L.get(i);
            Long I;
           I =  postulation.getIdEtudiant();
           Etudiant etudiant= etudiantService.findEtudiantById(I);
           resulat.add(etudiant);

        }
        return resulat;
    }


    public void deletePostulation(Long id){
        postulationRepo.deletePostulationById(id);
    }
}
