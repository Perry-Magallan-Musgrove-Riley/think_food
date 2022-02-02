package club.thinkfood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model, String username) {

        model.addAttribute("username", username);

        return "users/login";
    }
}
