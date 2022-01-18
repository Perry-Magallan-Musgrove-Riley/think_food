package club.thinkfood.repositories;

import club.thinkfood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserById(long id);
}
