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
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private boolean aTele;

    @Column(nullable = false)
    private boolean aCuisine;

    @Column(nullable = false)
    private boolean aMiniBar;

    @Column(nullable = false)
    private Long prix;

    @ManyToMany(cascade = { CascadeType.PERSIST})
    private List<Client> clients;




}