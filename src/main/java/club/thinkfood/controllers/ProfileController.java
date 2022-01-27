package club.thinkfood.controllers;


import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;

    public ProfileController(UserRepository userDao, RecipeRepository recipeDao) {
        this.userDao = userDao;
        this.recipeDao = recipeDao;
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("bio", currentUser.getBio());
        model.addAttribute("profileImg", currentUser.getImg());
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
        recipeDao.save(newRecipe);
        return "redirect:/profile";
    }


}
