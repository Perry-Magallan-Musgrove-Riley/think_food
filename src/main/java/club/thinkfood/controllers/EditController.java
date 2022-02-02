package club.thinkfood.controllers;


import club.thinkfood.models.Image;
import club.thinkfood.models.User;
import club.thinkfood.repositories.ImageRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditController {

    @Value(("${filestack.api}"))
    private String filestack;

    private final UserRepository userDao;
    private final ImageRepository imageDao;
    private final PasswordEncoder passwordEncoder;

    public EditController(UserRepository userDao, ImageRepository imageDao, PasswordEncoder passwordEncoder) {

        this.userDao = userDao;
        this.imageDao = imageDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/edit-picture")
    public String showEditProfileImage(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());

        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("filestack", filestack);
        model.addAttribute("image", new Image());
        model.addAttribute("user", new User());

        return "users/edit-picture";
    }

    @PostMapping("/edit-picture")
    public String editProfileImage(@ModelAttribute Image image){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());

        String imgPath = image.getImg_path();
        image.setImg_path(imgPath);
        imageDao.save(image);

        currentUser.setImg(image);
        userDao.save(currentUser);
        return "redirect:/profile";

    }

    @GetMapping("edit-bio")
    public String showEditBio(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());

        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("user", new User());
        model.addAttribute("bio", currentUser.getBio());

        return "users/edit-bio";
    }

    @PostMapping("edit-bio")
    public String editProfileBio(@ModelAttribute User user) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());

        String bio = user.getBio();
        currentUser.setBio(bio);
        userDao.save(currentUser);

        return "redirect:/profile";

    }
}
