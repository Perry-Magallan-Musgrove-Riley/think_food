package club.thinkfood.repositories;

import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findRecipesByTitleContains(String title);
    long findRecipeById(long id);
}
