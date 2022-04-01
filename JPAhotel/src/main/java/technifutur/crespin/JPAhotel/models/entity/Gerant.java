package technifutur.crespin.JPAhotel.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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