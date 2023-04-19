package tech.getarrays.EtudiantMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;

import java.util.Optional;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    void deleteEtudiantById(Long id);

    Optional<Etudiant> findEtudiantById(Long id);
    Optional<Etudiant> findEtudiantByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Etudiant a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableEtudiant(String email);


}
