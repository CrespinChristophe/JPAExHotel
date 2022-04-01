package technifutur.crespin.JPAhotel.model.forms;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data

public class GerantForm {

    private String nom;
    private String prenom;
    private LocalDateTime dateCarriere;

}
