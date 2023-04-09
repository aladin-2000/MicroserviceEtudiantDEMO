package tech.getarrays.EtudiantMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.EtudiantMicroservice.model.Postulation;

import java.util.Optional;

public interface PostulationRepo extends JpaRepository<Postulation, Long> {
    void deletePostulationById(Long id);
    Optional<Postulation> findPostulationById(Long id);


}
