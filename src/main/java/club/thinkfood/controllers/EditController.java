package club.thinkfood.controllers;


import club.thinkfood.models.Image;
import club.thinkfood.models.User;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    private UserRepository userDao;

    @Value(("${filestack.api}"))
    private String filestack;

    @GetMapping("/edit")
    public String editProfile(Model model){
        model.addAttribute("filestack", filestack);
        return "/users/edit";
    }

    @PostMapping("/edit")
    public String saveEdits(@ModelAttribute User user, @RequestParam(name = "imgPath") String imgPath, Model model){
        model.addAttribute("imgPath", imgPath);
        userDao.save(user);
        return "redirect:/users/profile";
    }

}
