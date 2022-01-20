package club.thinkfood.models;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private long prep_time;

    @Column(nullable = false, length = 5000)
    private String description;

    @Column
    private long rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "img")
    private List<Image> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @ManyToOne
    private User chef;

    @Value(("${spoonacularApi}"))
    private String spoonacularApiKey;

    @Value(("${filestackKey}"))
    private String filestackKey;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipes_categories", joinColumns = {@JoinColumn(name = "recipe_id")}, inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private List<Category> categories;

    @ManyToMany(mappedBy = "recipes")
    private List<User> chefs;

    @Value("${spoonacular.api}")
    private String spoonacularApiKey;

    public Recipe(long id, String title, long prep_time, List<Image> images, String description, User chef, long rating) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.images = images;
        this.description = description;
        this.chef = chef;
        this.rating = rating;
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Recipe() {
    }


    public User getUser() {
        return chef;
    }

    public void setUser(User user) {
        this.chef = user;
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

    public List<Image> getImage() {
        return images;
    }

    public void setImage(List<Image> images) {
        this.images = images;
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

