package tech.getarrays.EtudiantMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;

import java.util.Optional;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    void deleteEtudiantById(Long id);

    Optional<Etudiant> findEtudiantById(Long id);
    Optional<Etudiant> findEtudiantByEmail(String email);

}
