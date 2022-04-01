package technifutur.crespin.JPAhotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.models.entity.Chambre;
import technifutur.crespin.JPAhotel.models.entity.Hotel;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
}
