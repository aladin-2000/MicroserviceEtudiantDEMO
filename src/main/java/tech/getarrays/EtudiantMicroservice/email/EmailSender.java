package tech.getarrays.EtudiantMicroservice.email;

public interface EmailSender {
    void send(String to, String email);
}
