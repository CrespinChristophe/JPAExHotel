package technifutur.crespin.JPAhotel.model.forms;

import lombok.Data;

@Data
public class HotelForm {
    private String nom;
    private String adresse;
    private byte nbrEtoile;
}
