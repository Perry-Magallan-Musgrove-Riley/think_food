package club.thinkfood.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String body;

    @Column(nullable = true, length = 100)
    private String image;

    public Recipe(long id, String title, String body, String image, Users recipeCreator) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.recipeCreator = recipeCreator;
    }

    public Recipe(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Recipe() {}

    @ManyToOne
    @JoinColumn(name="user_id")
    private club.thinkfood.models.Users recipeCreator;

    public club.thinkfood.models.Users getRecipeCreator() {
        return recipeCreator;
    }

    public void setRecipeCreator(club.thinkfood.models.Users recipeCreator) {
        this.recipeCreator = recipeCreator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

