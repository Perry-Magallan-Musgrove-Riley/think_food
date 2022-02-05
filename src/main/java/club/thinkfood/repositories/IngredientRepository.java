package club.thinkfood.repositories;

import club.thinkfood.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findIngredientById(long id);
    Ingredient findIngredientByNameContains(String name);

//    List<Ingredient> findIngredientByIdContains(String name);
}
