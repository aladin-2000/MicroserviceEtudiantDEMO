package tech.getarrays.EtudiantMicroservice.model;



import javax.persistence.*;
import java.awt.image.VolatileImage;
import java.io.Serializable;

@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String filere;
    private String descreption;
    private String password;


    public Etudiant() {}

    public Etudiant(String firstname, String email, String lastname, String phone, String filere,String descreption,String password) {
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.password=password;
        this.lastname=lastname;
        this.filere=filere;
        this.descreption=descreption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }








    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getFirstname(){return firstname;}
    public void setFirstname(String firstname){this.firstname=firstname;}
    public String getLastname(){return lastname;}
    public void setLastname(String lastname){this.lastname=lastname;}
    public String getFilere(){return filere;}
    public void setFilere(String filere){this.filere=filere;}
    public String getDescreption(){return descreption;}
    public void setDescreption(String descreption){this.descreption=descreption;}





    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }









}
