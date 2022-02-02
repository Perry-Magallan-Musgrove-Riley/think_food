package club.thinkfood.models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String img_path;

    @ManyToOne
    private Recipe recipe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "img")
    private List<User> user;

    public Image(long id, String img_path) {
        this.id = id;
        this.img_path = img_path;
    }

    public Image() {}

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    public String getImg_path() {return img_path;}

    public void setImg_path(String img_path) {this.img_path = img_path;}
}
