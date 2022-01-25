package club.thinkfood.controllers;

import club.thinkfood.models.User;
import club.thinkfood.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    private final UserRepository userDao;

    public LoginController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/login")
    public String loginPage(Model model){

        List<User> users = userDao.findAll();
        model.addAttribute("users", users);

        return "users/login";
    }

    @PostMapping("/login")
    public String login(long id, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model){

        User user = userDao.getOne(id);
        boolean validUsername = username.equals(user.getUsername());
        boolean validPassword = password.equals(user.getPassword());
        String errorMsgUser = "No username found";
        String errorMsgPassword = "Password does not match";



      if(validUsername && validPassword){
          model.addAttribute("user", user);
      }
      return "users/profile";
//      else
//      {
//          user.
//      }
    }
}
