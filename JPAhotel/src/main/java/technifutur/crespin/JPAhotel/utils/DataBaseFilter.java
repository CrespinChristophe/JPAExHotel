package technifutur.crespin.JPAhotel.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.data.repo.HotelRepository;
import technifutur.crespin.JPAhotel.model.entities.Gerant;

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




    }
}
