package tech.getarrays.EtudiantMicroservice.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sujet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String detail;
    private String nomEncadrantComplet;
    private Long idEncadrant;
    private  boolean valide;
    private boolean taken;



    private String filere;


    public Sujet() {}

    public Sujet(String title, String detail,Long idEncadrant,String filere,String nomEncadrantComplet,boolean valide,boolean taken) {
        this.filere=filere;
        this.detail=detail;
        this.title=title;
        this.idEncadrant=idEncadrant;
        this.nomEncadrantComplet=nomEncadrantComplet;
        this.valide=valide;
        this.taken=taken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilere(){return filere;}
    public void setFilere(String filere){this.filere=filere;}


    public Long getIdEncadrant() {
        return idEncadrant;
    }

    public void setIdEncadrant(Long idEncadrant) {
        this.idEncadrant = idEncadrant;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNomEncadrantComplet() {
        return nomEncadrantComplet;
    }

    public void setNomEncadrantComplet(String nomEncadrantComplet) {
        this.nomEncadrantComplet = nomEncadrantComplet;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
    public boolean getValide(){
       return this.valide=valide;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public boolean getTaken(){
        return this.taken=taken;
    }
}
