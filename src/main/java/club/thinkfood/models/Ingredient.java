package club.thinkfood.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany
    private List<Recipe> recipe;

    public Ingredient() {}

    public Ingredient(long id, String name, List<Recipe> recipe) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
