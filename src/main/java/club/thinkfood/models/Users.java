package club.thinkfood.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false, length = 100)
    private String first_name;

    @Column(nullable = false, length = 100)
    private String last_name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToOne
    @JoinColumn(name = "img_id")
    private Users recipeCreator;

    @Column(nullable = false)
    private int isAdmin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeCreator")
    private List<Recipes> myRecipes;

    public Users(long id, String first_name, String last_name, String email, String username, String password, Users recipeCreator, int isAdmin, List<Recipes> myRecipes) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.recipeCreator = recipeCreator;
        this.isAdmin = isAdmin;
        this.myRecipes = myRecipes;
    }

    public Users(Users copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public Users() {}

    public List<Recipes> getMyRecipes() {
        return myRecipes;
    }

    public void setMyRecipes(List<Recipes> myRecipes) {
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

    public Users getRecipeCreator() {
        return recipeCreator;
    }

    public void setRecipeCreator(Users recipeCreator) {
        this.recipeCreator = recipeCreator;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}

