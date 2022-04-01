package technifutur.crespin.JPAhotel.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nbr_etoile", columnDefinition = "VARCHAR(5)")
    private String nbrEtoile;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @OneToOne
    private Gerant gerant;

    @OneToMany(cascade = { CascadeType.PERSIST})
    private List<Chambre> chambres;


}