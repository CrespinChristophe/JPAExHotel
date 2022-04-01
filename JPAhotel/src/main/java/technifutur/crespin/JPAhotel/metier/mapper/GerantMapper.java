package technifutur.crespin.JPAhotel.metier.mapper;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.entities.Hotel;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

@Service
public class GerantMapper {

    //prends un entity et le transforme en DTO
    public GerantDTO entityToDTO(Gerant entity){


        if(entity == null)
            return null;

        Hotel hotelEntity = entity.getHotel();
        GerantDTO.HotelDTO hotel = hotelEntity == null ? null :
                new GerantDTO.HotelDTO( hotelEntity.getId(), hotelEntity.getNom() );


        return GerantDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .debutCarriere(entity.getDebutCarriere())
                .hotel(hotel)
                .build();


    }

    public Gerant formToEntity(GerantForm form){

        if(form == null)
            return null;

        return Gerant.builder()
                .nom(form.getNom())
                .prenom(form.getPrenom())
                .debutCarriere(form.getDateCarriere())
                .build();

    }

}
