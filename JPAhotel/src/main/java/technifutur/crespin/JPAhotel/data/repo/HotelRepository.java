package technifutur.crespin.JPAhotel.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.model.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
