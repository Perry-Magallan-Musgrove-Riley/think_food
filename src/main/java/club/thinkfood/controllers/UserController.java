package club.thinkfood.controllers;

import club.thinkfood.models.Image;
import club.thinkfood.models.User;
import club.thinkfood.repositories.ImageRepository;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import club.thinkfood.services.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final RecipeRepository recipeDao;
    private final ImageRepository imageDao;

    public UserController(PasswordEncoder passwordEncoder, EmailService emailService, RecipeRepository recipeDao, UserRepository userDao, ImageRepository imageDao) {
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.recipeDao = recipeDao;
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("image", new Image());

        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {

        String username = user.getUsername();
        String email = user.getEmail();
        String hash = passwordEncoder.encode(user.getPassword());
        Image defaultImg = imageDao.findImageById(1);

        user.setPassword(hash);
        user.setUsername(username);
        user.setEmail(email);
        user.setImg(defaultImg);

        emailService.prepareAndSend(user, "Sign up confirmed", "Thank you for being a user.");
        userDao.save(user);

//        if(user.getUsername().equals("MagallanK") || user.getUsername().equals("alex") || user.getUsername().equals("dez") || user.getUsername().equals("rodriques") ){
//            user.setIsAdmin(1);
//        }

        return "redirect:/login";
    }

    @GetMapping("/resetPassword")
    public String resetPassword(Model model) {

        model.addAttribute("loginUser", new User());

        return "users/resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetSuccess(@ModelAttribute User loginUser) {

        userDao.save(loginUser);

        return "redirect:/login";
    }

//    @GetMapping("users/profile")
//    public String toProfile(Model model, User){
//        model.getAttribute()
//        return "/profile/{username}";
//    }


}
