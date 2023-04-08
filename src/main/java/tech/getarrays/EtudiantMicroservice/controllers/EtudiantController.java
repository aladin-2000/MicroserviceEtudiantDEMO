package tech.getarrays.EtudiantMicroservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;
import tech.getarrays.EtudiantMicroservice.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>> getAllEtudiants () {
        List<Etudiant> etudiants = etudiantService.findAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Etudiant> getEtudiantById (@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant updateEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updateEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Etudiant etudiant)
    {
        String email=etudiant.getEmail();
        String password=etudiant.getPassword();
        return new ResponseEntity<>(etudiantService.login(email,password), HttpStatus.OK);
    }
}
