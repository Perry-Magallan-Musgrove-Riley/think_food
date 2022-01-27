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

    @Column
    private String timeStamp;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Image> images;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @ManyToOne
    private User chef;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipes_categories", joinColumns = {@JoinColumn(name = "recipe_id")}, inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private List<Category> categories;

    @ManyToMany(mappedBy = "recipes")
    private List<User> chefs;

    public Recipe(long id, String title, long prep_time, List<Image> images, String description, User chef, long rating, String timeStamp) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.images = images;
        this.description = description;
        this.chef = chef;
        this.rating = rating;
        this.timeStamp = timeStamp;
    }

    public Recipe(long id, String title, long prep_time, String description, long rating, List<Image> images) {
        this.id = id;
        this.title = title;
        this.prep_time = prep_time;
        this.description = description;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

