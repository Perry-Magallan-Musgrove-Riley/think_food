package club.thinkfood.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false)
    private String img_name;

    @ManyToOne
    private Recipe img;

    public Image(long id, String img_name) {
        this.id = id;
        this.img_name = img_name;
    }

    public Image() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }
}
