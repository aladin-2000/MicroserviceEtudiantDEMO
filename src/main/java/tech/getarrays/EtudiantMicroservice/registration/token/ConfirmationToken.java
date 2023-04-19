package tech.getarrays.EtudiantMicroservice.registration.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.getarrays.EtudiantMicroservice.model.Etudiant;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ConfirmationToken_etudiant")
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence_etudiant",
            sequenceName = "confirmation_token_sequence_etudiant",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence_etudiant"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "etudiant_id"
    )
    private Etudiant etudiant;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Etudiant etudiant) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.etudiant = etudiant;
    }
}
