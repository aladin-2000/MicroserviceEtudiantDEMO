package tech.getarrays.EtudiantMicroservice.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EtudiantMicroservice.exception.UserNotFoundException;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;
import tech.getarrays.EtudiantMicroservice.registration.token.ConfirmationToken;
import tech.getarrays.EtudiantMicroservice.registration.token.ConfirmationTokenService;
import tech.getarrays.EtudiantMicroservice.repo.EtudiantRepo;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class EtudiantService {
    private final EtudiantRepo etudiantRepo;
    private final ConfirmationTokenService confirmationTokenService;


    @Autowired
    public EtudiantService(EtudiantRepo etudiantRepo ,ConfirmationTokenService confirmationTokenService) {
        this.etudiantRepo = etudiantRepo;
        this.confirmationTokenService=confirmationTokenService;
    }

    public Etudiant addEtudiantt(Etudiant etudiant) {
        etudiant.setPassword(BCrypt.hashpw(etudiant.getPassword(),BCrypt.gensalt()));
        etudiant.setEnabled(true);
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
        if (!( BCrypt.checkpw(password,etudiant.getPassword()) && etudiant.getEnabled())==true) {
            throw new UserNotFoundException("Email ou mot de passe sont incorrecte ");
        }
        return etudiant;


    }

    public String addEtudiant(Etudiant etudiant) {
        etudiant.setPassword(BCrypt.hashpw(etudiant.getPassword(),BCrypt.gensalt()));
        etudiantRepo.save(etudiant);
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                etudiant
        );
        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

    public int enableEtudiant(String email) {
        return etudiantRepo.enableEtudiant(email);
    }

}
