package technifutur.crespin.JPAhotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import technifutur.crespin.JPAhotel.model.entities.Gerant;

@Data
@Builder
public class HotelDTO {
    private Long id;
    private byte nbrEtoile;
    private String nom;
    String adresse;
    private GerantDTO gerant;
    //private ChambreDTO chambre;

    @Data
    @AllArgsConstructor
    public static class GerantDTO{
        private Long id;
        private String nom;
    }
}
