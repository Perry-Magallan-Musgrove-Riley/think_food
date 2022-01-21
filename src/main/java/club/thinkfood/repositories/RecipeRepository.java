package club.thinkfood.repositories;

import club.thinkfood.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByTitle(String title);

//    List<Recipe> findRecipesByTitleIsLike(String title);

    List<Recipe>  findRecipesByTitleLike(String title);

    List<Recipe> findRecipesByTitleContains(String title);
}
