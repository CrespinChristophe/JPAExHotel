package technifutur.crespin.JPAhotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.models.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
