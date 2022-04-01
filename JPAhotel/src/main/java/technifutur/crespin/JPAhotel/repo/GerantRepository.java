package technifutur.crespin.JPAhotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.models.entity.Gerant;
import technifutur.crespin.JPAhotel.models.entity.Hotel;

public interface GerantRepository  extends JpaRepository<Gerant, Long> {
}
