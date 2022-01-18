package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String HomePage(){
        return "index";
    }

    @PostMapping("/")
    public String SignUp(){
        //later setup authentication
        return "redirect:/users/sign-up";
    }

}
