package club.thinkfood.models;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
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

    @CreationTimestamp
    private LocalDateTime timeStamp;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Image> images;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipes_ingredients", joinColumns = {@JoinColumn(name = "recipe_id")}, inverseJoinColumns = {@JoinColumn(name = "ingredients_id")})
    private List<Ingredient> ingredients;

    @ManyToOne
    private User chef;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipes_categories", joinColumns = {@JoinColumn(name = "recipe_id")}, inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private List<Category> categories;

    @ManyToMany(mappedBy = "recipes")
    private List<User> chefs;

    @Column(nullable = false)
    private long quantity;

    @Column(nullable = false)
    private String measurement;

    public Recipe(long id, String title, long prep_time, List<Image> images, String description, User chef, long rating, LocalDateTime timeStamp) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.images = images;
        this.description = description;
        this.chef = chef;
        this.rating = rating;
        this.timeStamp = timeStamp;
    }

    public Recipe(long id, String title, long prep_time, String description, long quantity, String measurement, long rating, List<Image> images) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.description = description;
        this.quantity = quantity;
        this.measurement = measurement;
        this.rating = rating;
        this.images = images;
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Recipe() {}

    public Recipe(User chef) {
        this.chef = chef;
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

    public User getChef() {
        return chef;
    }

    public void setChef(User chef) {
        this.chef = chef;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {}

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

