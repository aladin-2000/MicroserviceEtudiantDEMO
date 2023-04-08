package tech.getarrays.EtudiantMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EtudiantMicroservice.model.Postulation;
import tech.getarrays.EtudiantMicroservice.repo.PostulationRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostulationService {
    private final PostulationRepo postulationRepo;

    @Autowired
    public PostulationService(PostulationRepo postulationRepo) {
        this.postulationRepo = postulationRepo;
    }

    public Postulation addPostulation(Postulation postulation) {
        return postulationRepo.save(postulation);
    }

    public List<Postulation> findAllPostulations() {
        return postulationRepo.findAll();
    }

    public Postulation updatePostulation(Postulation postulation) {
        return postulationRepo.save(postulation);
    }



    public void deletePostulation(Long id){
        postulationRepo.deletePostulationById(id);
    }
}
