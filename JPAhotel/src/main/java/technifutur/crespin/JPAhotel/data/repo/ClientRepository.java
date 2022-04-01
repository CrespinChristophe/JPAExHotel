package technifutur.crespin.JPAhotel.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.model.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
