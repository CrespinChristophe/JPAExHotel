package technifutur.crespin.JPAhotel.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.data.repo.HotelRepository;
import technifutur.crespin.JPAhotel.data.repo.UserRepository;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.entities.Hotel;
import technifutur.crespin.JPAhotel.model.entities.User;

import java.time.LocalDateTime;

@Component
public class DataBaseFiller implements InitializingBean {

    private final HotelRepository repository;
    private final GerantRepository gRepo;
    private final UserRepository uRepo;
    private final PasswordEncoder encoder;


    public DataBaseFiller(HotelRepository repository, GerantRepository gRepo, UserRepository uRepo, PasswordEncoder encoder) {
        this.repository = repository;
        this.gRepo = gRepo;
        this.uRepo = uRepo;
        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setupHotelGerant();

        User user = new User();
        user.setUsername("user");
        user.setPassword(encoder.encode("pass)"));

        uRepo.save(user);


    }

    private void setupHotelGerant(){
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
                .nbrEtoile((byte)3)
                .nom("Hotel du nord")
                .build();
        repository.save(h);

        h = Hotel.builder()
                .adresse("rue du sud")
                .nbrEtoile((byte)5)
                .nom("Hotel du sud")
                .build();
        repository.save(h);


        h = Hotel.builder()
                .adresse("rue du l'est")
                .nbrEtoile((byte)1)
                .nom("Hotel de l'est")
                .build();
        repository.save(h);
    }

}
