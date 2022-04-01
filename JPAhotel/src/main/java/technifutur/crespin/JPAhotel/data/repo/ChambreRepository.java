package technifutur.crespin.JPAhotel.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.model.entities.Chambre;

public interface ChambreRepository  extends JpaRepository<Chambre, Long> {
}
