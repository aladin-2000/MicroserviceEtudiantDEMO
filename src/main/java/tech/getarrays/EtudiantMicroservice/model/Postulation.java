package tech.getarrays.EtudiantMicroservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Postulation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long idSujet;
    private Long idEtudiant;

    public Postulation(Long idSujet,Long idEtudiant) {


        this.idSujet = idSujet;
        this.idEtudiant = idEtudiant;
    }
    public Postulation() {}


        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSujet() {
        return idSujet;
    }

    public void setIdidSujet(Long idSujet) {
        this.idSujet = idSujet;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }














    @Override
    public String toString() {
        return "Employee{" +
                "idPostulation=" + id +
                ", idSujet='" + idSujet + '\'' +
                ", idEtudiant='" + idEtudiant + '\'' +
                '}';
    }
}
