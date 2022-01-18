package club.thinkfood.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private long prep_time;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false, length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users recipeCreator;

    @Column
    private long rating;

    public Recipes(long id, String title, long prep_time, String image, String description, Users recipeCreator, long rating) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.image = image;
        this.description = description;
        this.recipeCreator = recipeCreator;
        this.rating = rating;
    }

    public Recipes(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Recipes() {
    }


    public Users getRecipeCreator() {
        return recipeCreator;
    }

    public void setRecipeCreator(Users recipeCreator) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(long prep_time) {
        this.prep_time = prep_time;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}

