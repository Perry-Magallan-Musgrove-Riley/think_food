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

    private final UserRepository userDao;
    private final ImageRepository imageDao;
    private final PasswordEncoder passwordEncoder;

    public EditController(UserRepository userDao, ImageRepository imageDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.imageDao = imageDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Value(("${filestack.api}"))
    private String filestack;

    @GetMapping("/edit")
    public String editProfile(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());
        System.out.println("currentUser = " + currentUser);

        model.addAttribute("username", currentUser.getUsername());
        System.out.println("model.addAttribute(\"username\", currentUser.getUsername()) = " + model.addAttribute("username", currentUser.getUsername()));
        model.addAttribute("filestack", filestack);
        System.out.println("model.addAttribute(\"filestack\", filestack) = " + model.addAttribute("filestack", filestack));
        model.addAttribute("image", new Image());
        System.out.println("model.addAttribute(\"image\", new Image()) = " + model.addAttribute("image", new Image()));
        model.addAttribute("user", new User());
        return "/users/edit";
    }

    @PostMapping("/edit")
    public String editProfileImage(@ModelAttribute Image image){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User persistUser = userDao.findByUsername(loggedInUser.getUsername());

        String imgPath = image.getImg_path();
        image.setImg_path(imgPath);
        imageDao.save(image);

        persistUser.setImg(image);
        userDao.save(persistUser);
        return "redirect:/";

    }
}
