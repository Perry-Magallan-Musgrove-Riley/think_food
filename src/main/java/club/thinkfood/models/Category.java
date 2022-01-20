package club.thinkfood.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column
    private String cat_name;

    @ManyToMany(mappedBy = "categories")
    private List<Recipe> recipes;

    public Category(){}

    public Category(long id, String cat_name) {
        this.id = id;
        this.cat_name = cat_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
}
