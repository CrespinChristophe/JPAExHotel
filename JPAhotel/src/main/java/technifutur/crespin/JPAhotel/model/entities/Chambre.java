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
@Table(name = "chambre")
public class Chambre {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_chambre", nullable = false)
    private int  numChambre;

    @Column(nullable = false)
    private boolean aTele;

    @Column(nullable = false)
    private boolean aCuisine;

    @Column(name ="a_minibar", nullable = false)
    private boolean aMiniBar;

    @Column(nullable = false, precision = 2)//2 chiffres après la virgule
    private float prix;

    @ManyToMany//c'est ça qui donne la colonne de jointure
    @JoinTable(name = "visite",
            joinColumns = @JoinColumn(name = "chambre_id"),//joinColumns fait ref à l'entité elle-même
            inverseJoinColumns = @JoinColumn(name = "visiteur_id"),//inverseJoinColumns se réfère au client
            uniqueConstraints = @UniqueConstraint(name = "UNIK_visiteur_chambre",
                    columnNames = {"chambre_id", "visiteur_id"} )//permet de définir une contrainte d'unicité
    )
    private List<Client> clients = new ArrayList<>();//pour etre certain d'avoir une ArrayList

    @ManyToOne
    private Hotel hotel;



}