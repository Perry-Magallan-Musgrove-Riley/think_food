package club.thinkfood.repositories;

import club.thinkfood.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
    Image findImagesById( long id);
}
