package technifutur.crespin.JPAhotel.metier.mapper;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.dto.HotelDTO;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.entities.Hotel;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;
import technifutur.crespin.JPAhotel.model.forms.HotelForm;

@Service
public class HotelMapper {

    public HotelDTO entityToDTO(Hotel entity){

        if(entity == null)
            return null;

        Gerant gerantEntity = entity.getGerant();
        HotelDTO.GerantDTO gerant = gerantEntity == null ? null :
                new HotelDTO.GerantDTO( gerantEntity.getId(), gerantEntity.getNom() );

        return HotelDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .adresse(entity.getAdresse())
                .nbrEtoile(entity.getNbrEtoile())
                .gerant(gerant)
                .build();


    }

    public Hotel formToEntity(HotelForm form){
        if(form == null)
            return null;

        return Hotel.builder()
                .nom(form.getNom())
                .adresse(form.getAdresse())
                .nbrEtoile(form.getNbrEtoile())
                .build();
    }

    /*public GerantDTO entityToDTO(Gerant entity){


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

    }*/

}
