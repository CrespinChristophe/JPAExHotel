package technifutur.crespin.JPAhotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data//ne s'applique que sur GerantDTO
@Builder//ne s'applique que sur GerantDTO donc spécifier les annotations pour HotelDTO

public class GerantDTO {

    private Long id;
    private String nom;
    private String prenom;
    private LocalDateTime debutCarriere;
    private HotelDTO hotel;

    @Data
    @AllArgsConstructor
    public static class HotelDTO{
        private Long id;
        private String nom;
    }



}
