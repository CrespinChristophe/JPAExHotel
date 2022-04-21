package technifutur.crespin.JPAhotel.model.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class HotelForm {
    private String nom;
    private String adresse;
    private byte nbrEtoile;
}
