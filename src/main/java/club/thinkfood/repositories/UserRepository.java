package club.thinkfood.repositories;

import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserById(long id);
    List<Recipe> findUserByUsernameIsLike(User chef);
    User findByUsername(String username);
}
