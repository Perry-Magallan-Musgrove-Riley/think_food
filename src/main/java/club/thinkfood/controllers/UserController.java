package club.thinkfood.controllers;

import club.thinkfood.models.User;
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

    public UserController(PasswordEncoder passwordEncoder, EmailService emailService, RecipeRepository recipeDao, UserRepository userDao) {
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.recipeDao = recipeDao;
        this.userDao = userDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        user.setUsername(username);
        user.setEmail(email);

        emailService.prepareAndSend(user, "Sign up confirmed", "Thank you for being a user.");
        userDao.save(user);

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
