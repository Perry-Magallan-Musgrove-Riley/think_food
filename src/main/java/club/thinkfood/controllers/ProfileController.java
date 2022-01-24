package club.thinkfood.controllers;


import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    private UserRepository userDao;
    private RecipeRepository recipeDao;

    @GetMapping("/profile/{name}")
    public String profile(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "/users/profile";
    }

    @GetMapping("/create")
    public String viewCreatePost(Model model){
//        model.addAttribute("newRecipe", new Recipe());
        return "users/create";
    }

    @PostMapping("/users/create")
    public String createPost(@ModelAttribute Recipe newRecipe){

//        User recipeCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

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
