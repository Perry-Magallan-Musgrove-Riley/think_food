package club.thinkfood.repositories;

import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    List<Recipe> findAllByTitle(String title);

//    List<Recipe> findRecipesByChefIsLike(User chef);

//    List<Recipe>  findRecipesByDescriptionIsLike(String description);

    List<Recipe> findRecipesByTitleContains(String title);
}
