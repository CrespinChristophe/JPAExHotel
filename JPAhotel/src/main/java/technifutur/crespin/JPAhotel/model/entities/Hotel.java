package technifutur.crespin.JPAhotel.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /*@Column(name = "nbr_etoile", columnDefinition = "VARCHAR(5)")
    private String nbrEtoile;*/
    @Column(name = "nbr_etoiles", columnDefinition = "INT NOT NULL CHECK (nbr_etoiles <= 5 AND nbr_etoiles >=1)")
    private byte nbrEtoile;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, columnDefinition = "VARCHAR(200) DEFAULT 'inconnu'", insertable = false)
    private String adresse;//on peut mettre une valeur par défaut niveau JAVA si code first, ex adresse ="inconnu"
    // OU du côté SQL, comme ici, si DB First(si la DB existe déjà)

    @OneToOne
    @JoinColumn(name = "manager_id", foreignKey = @ForeignKey(name = "FK_HOTEL_GERANT_ID"))//permet de modifier
    //la colonne de jointure. le mettre du coté fort.
    //nom de la colonne FK dans la table (manager_id) , puis nom de l'index (FK_HOTEL_GERANT_ID)
    private Gerant gerant;//FK

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres = new ArrayList<>();//pour être sur davoir une arrayList


}