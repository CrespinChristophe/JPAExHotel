package technifutur.crespin.JPAhotel.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "gerant")
public class Gerant {
    @Id
    //généré auto via la stratégie IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false)
    private LocalDateTime debutCarriere;

    @OneToOne(mappedBy = "gerant")
    private Hotel hotel;

}