package club.thinkfood.controllers;

import club.thinkfood.models.User;
import club.thinkfood.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
//    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/resetPassword")
    public String resetPassword(Model model){
        model.addAttribute("loginUser", new User());
        return "users/resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetSuccess(@ModelAttribute User loginUser){
        userDao.save(loginUser);
        return "redirect:/login";
    }


}
