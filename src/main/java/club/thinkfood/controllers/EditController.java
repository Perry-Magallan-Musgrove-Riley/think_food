package club.thinkfood.controllers;


import club.thinkfood.models.User;
import club.thinkfood.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {

    private UserRepository userDao;

    @GetMapping("/edit")
    public String editProfile(){
        return "/users/edit";
    }

    @PostMapping("/edit")
    public String saveEdits(@ModelAttribute User user){
        userDao.save(user);
        return "redirect:/users/profile";
    }

}
