package club.thinkfood.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String first_name;

    @Column(length = 100)
    private String last_name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column
    private int isAdmin;

    @Column(length = 5000)
    private String bio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chef")
    private List<Recipe> myRecipes;

    @ManyToOne
    private Image img;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_recipes", joinColumns = {@JoinColumn(name = "chef_id")}, inverseJoinColumns = {@JoinColumn(name = "recipe_id")})
    private List<Recipe> recipes;

    public User(long id, String first_name, String last_name, String email, String username, String password, Image img, int isAdmin, List<Recipe> myRecipes) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.img = img;
        this.isAdmin = isAdmin;
        this.myRecipes = myRecipes;
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(User copy) {
        this.id = copy.id; //THIS IS NEEDED AND HAS TO HAVE ALL PARAMETERS FROM CONSTRUCTOR
        this.first_name = copy.first_name;
        this.last_name = copy.last_name;
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
        this.img = copy.img;
        this.isAdmin = copy.isAdmin;
        this.myRecipes = copy.myRecipes;
    }

    public User() {}

    public List<Recipe> getMyRecipes() {
        return myRecipes;
    }

    public void setMyRecipes(List<Recipe> myRecipes) {
        this.myRecipes = myRecipes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getBio() {return bio;}

    public void setBio(String bio) {
        this.bio = bio;
    }
}

