package technifutur.crespin.JPAhotel.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import technifutur.crespin.JPAhotel.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /*public*/ Optional<User> findByUsername(String username);// c'est public par défaut

}
