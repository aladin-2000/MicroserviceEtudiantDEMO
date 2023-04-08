package tech.getarrays.EtudiantMicroservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.EtudiantMicroservice.model.Postulation;
import tech.getarrays.EtudiantMicroservice.service.PostulationService;

import java.util.List;

@RestController
@RequestMapping("/Postulation")
public class PostulationController {
    private final PostulationService postulationService;

    public PostulationController(PostulationService postulationService) {
        this.postulationService = postulationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Postulation>> getAllPostulations () {
        List<Postulation> postulations = postulationService.findAllPostulations();
        return new ResponseEntity<>(postulations, HttpStatus.OK);
    }



    @PostMapping("/add")
    public ResponseEntity<Postulation> addPostulation(@RequestBody Postulation postulation) {
        Postulation newPostulation = postulationService.addPostulation(postulation);
        return new ResponseEntity<>(newPostulation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Postulation> updatePostulation(@RequestBody Postulation postulation) {
        Postulation updatePostulation = postulationService.updatePostulation(postulation);
        return new ResponseEntity<>(updatePostulation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostulation(@PathVariable("id") Long id) {
        postulationService.deletePostulation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
