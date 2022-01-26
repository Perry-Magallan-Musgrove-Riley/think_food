package club.thinkfood.controllers;


import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {


    private UserRepository userDao;
    private RecipeRepository recipeDao;


    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "/users/profile";
    }

    @PostMapping("profile/{username}")
    public String viewProfile(@PathVariable String username, @ModelAttribute User user) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setUsername(loggedInUser.getUsername());
        return "/users/profile";
    }


    @GetMapping("/create")
    public String viewCreatePost(Model model){
//        model.addAttribute("newRecipe", new Recipe());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String createPost(@ModelAttribute Recipe newRecipe){

        User recipeCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        newRecipe.setUser(userDao.findUserById(1L));
//        newRecipe.setUser(recipeCreator);

//        String emailSubject = newRecipe.getUser().getUsername() + ", your recipe has been created!";
//
//        String emailBody = "Congratulations - your latest recipe is up and ready to view on your profile page. Your recipe reads: " + newRecipe.getDescription();
//        emailService.prepareAndSend(newRecipe, emailSubject, emailBody);
        recipeDao.save(newRecipe);
        return "redirect:/profile";
    }


}
