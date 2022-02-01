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

    @GetMapping("/profile")
    public String profile(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findUserById(loggedInUser.getId());
        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("bio", currentUser.getBio());
        model.addAttribute("profileImg", currentUser.getImg().getImg_path());
        return "/users/profile";
    }

    @GetMapping("/recipes/create")
    public String viewCreatePost(Model model){
        model.addAttribute("newRecipe", new Recipe());
        return "recipes/create";
    }

    @PostMapping("/recipes/create")
    public String createPost(@ModelAttribute Recipe newRecipe){
        System.out.println("The post mapping worked. This is line 41.");
        User recipeCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newRecipe.setUser(recipeCreator);

            recipeDao.save(newRecipe);
        return "redirect:/profile";
    }

    @GetMapping("/recipes/edit/{id}")
    public String editRecipe(@PathVariable long id, Model model) {
        Recipe editRecipe = recipeDao.getById(id);

        model.addAttribute("recipeToEdit", editRecipe);
        return "/recipes/editRecipe";
    }

    @PostMapping("/recipes/edit")
    public String saveEditRecipe(@RequestParam(name = "recipeTitle") String recipeTitle, @RequestParam(name = "recipeDescription") String recipeDescription, @RequestParam(name = "recipePrepTime") long recipePrepTime, @RequestParam(name = "recipeId") long id) {

        Recipe recipeToEdit = recipeDao.getById(id);
        recipeToEdit.setTitle(recipeTitle);
        recipeToEdit.setDescription(recipeDescription);
        recipeToEdit.setPrep_time(recipePrepTime);


        recipeDao.save(recipeToEdit);

        return "redirect:/recipe";
    }

    @PostMapping("recipes/delete/{id}")
    public String deleteRecipe(@PathVariable long id){

        long deleteRecipeId = id;
        recipeDao.deleteById(deleteRecipeId);

        return "redirect:/recipe";
    }
}
