package tech.getarrays.EtudiantMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.getarrays.EtudiantMicroservice.exception.UserNotFoundException;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;
import tech.getarrays.EtudiantMicroservice.repo.EtudiantRepo;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EtudiantService {
    private final EtudiantRepo etudiantRepo;

    @Autowired
    public EtudiantService(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    public Etudiant addEtudiant(Etudiant etudiant) {

        return etudiantRepo.save(etudiant);
    }

    public List<Etudiant> findAllEtudiants() {
        return etudiantRepo.findAll();
    }

    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    public Etudiant findEtudiantById(Long id) {
        return etudiantRepo.findEtudiantById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEtudiant(Long id){
        etudiantRepo.deleteEtudiantById(id);
    }

    public Etudiant login(String email, String password){
        Etudiant etudiant = etudiantRepo.findEtudiantByEmail(email).orElseThrow(() -> new UserNotFoundException("Email ou mot de passe est incorrecte"));
        if (!password.equals(etudiant.getPassword())) {
            throw new UserNotFoundException("Email ou mot de passe sont incorrecte ");
        }
        return etudiant;


    }
}
