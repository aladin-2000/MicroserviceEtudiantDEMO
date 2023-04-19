package tech.getarrays.EtudiantMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.EtudiantMicroservice.model.Postulation;

import java.util.List;
import java.util.Optional;

public interface PostulationRepo extends JpaRepository<Postulation, Long> {
    void deletePostulationById(Long id);
    Optional<Postulation> findPostulationById(Long id);

    @Query("SELECT p FROM Postulation p WHERE p.idSujet = ?1")
    List<Postulation> FindEtudiantByIdSujet(Long idSujet);




}
