package technifutur.crespin.JPAhotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.models.entity.Client;
import technifutur.crespin.JPAhotel.models.entity.Hotel;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
