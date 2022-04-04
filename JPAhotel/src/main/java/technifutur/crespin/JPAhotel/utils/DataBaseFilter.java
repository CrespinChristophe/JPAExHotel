package technifutur.crespin.JPAhotel.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.data.repo.HotelRepository;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.entities.Hotel;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class DataBaseFilter implements InitializingBean {

    private final HotelRepository repository;
    private final GerantRepository gRepo;

    public DataBaseFilter(HotelRepository repository, GerantRepository gRepo) {
        this.repository = repository;
        this.gRepo = gRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Gerant g = Gerant.builder()
                .debutCarriere(LocalDateTime.now())
                .prenom("luc")
                .nom("dubois")
                .build();
        gRepo.save(g);

        g = Gerant.builder()
                .debutCarriere(LocalDateTime.now().minusDays(2))
                .prenom("Marie")
                .nom("Desmet")
                .build();
        gRepo.save(g);

        Hotel h = Hotel.builder()
                .adresse("rue du nord")
                .id(133L)
                .nbrEtoile((byte)3)
                .nom("Hotel du nord")
                .build();

        h = Hotel.builder()
                .adresse("rue du sud")
                .id(132L)
                .nbrEtoile((byte)5)
                .nom("Hotel du sud")
                .build();

        Hotel.builder()
                .adresse("rue du l'est")
                .id(131L)
                .nbrEtoile((byte)1)
                .nom("Hotel de l'est")
                .build();




    }
}
