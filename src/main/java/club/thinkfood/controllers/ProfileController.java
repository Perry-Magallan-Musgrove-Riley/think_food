package club.thinkfood.controllers;

import club.thinkfood.models.Ingredient;
import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.IngredientRepository;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// **DEZ comments**

@Controller
public class ProfileController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;
    private final IngredientRepository ingredientDao;

    public ProfileController(UserRepository userDao, RecipeRepository recipeDao, IngredientRepository ingredientDao) {

        this.userDao = userDao;
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
    }

    @GetMapping("/profile")
    public String profile(Model model/*, @RequestParam(name = "name") String name*/) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findUserById(loggedInUser.getId());

//        Ingredient ingredient = ingredientDao.findIngredientByNameContains(name);

        List<Recipe> userRecipes = userDao.findUserById(loggedInUser.getId()).getMyRecipes();


        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("bio", currentUser.getBio());
        model.addAttribute("profileImg", currentUser.getImg().getImg_path());

//        model.addAttribute("recipes", recipes);

        model.addAttribute("userRecipes", userRecipes);
        System.out.println("currentUser = " + currentUser.getIsAdmin());
        System.out.println("loggedInUser = " + loggedInUser.getIsAdmin());

//        model.addAttribute("recipeIngredients", ingredient);

        return "users/profile";
    }


    @GetMapping("/recipes/create")
    public String viewCreatePost(Model model){

        model.addAttribute("newRecipe", new Recipe());

        return "recipes/create";
    }

    @PostMapping("/recipes/create")
    public String createPost(@ModelAttribute Recipe newRecipe){

        User recipeCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newRecipe.setUser(recipeCreator);

        recipeDao.save(newRecipe);

        return "redirect:/profile";
    }

    @GetMapping("/recipes/edit/{id}")
    public String editRecipe(@PathVariable long id, @PathVariable String name, Model model) {

        Recipe editRecipe = recipeDao.getById(id);
        Ingredient editIngredient = ingredientDao.findIngredientByNameContains(name);

        model.addAttribute("recipeToEdit", editRecipe);
        model.addAttribute("ingredientToEdit", editIngredient);

        return "recipes/editRecipe";
    }

    @PostMapping("/recipes/edit")
    public String saveEditRecipe(@RequestParam(name = "recipeTitle") String recipeTitle, @RequestParam(name = "recipeDescription") String recipeDescription, @RequestParam(name = "ingredientName") String name, @RequestParam(name = "recipePrepTime") long recipePrepTime, @RequestParam(name = "recipeId") long id, @RequestParam(name = "ingredientId") long ingredientId) {

        Ingredient ingredientToEdit = ingredientDao.findIngredientById(ingredientId);
        Recipe recipeToEdit = recipeDao.getById(id);
        recipeToEdit.setTitle(recipeTitle);
        recipeToEdit.setDescription(recipeDescription);
        recipeToEdit.setPrep_time(recipePrepTime);
        ingredientToEdit.setName(name);

        recipeDao.save(recipeToEdit);

        return "redirect:/profile";
    }

    @PostMapping("recipes/delete/{id}")
    public String deleteRecipe(@PathVariable long id){

        long deleteRecipeId = id;
        recipeDao.deleteById(deleteRecipeId);

        return "redirect:/profile";
    }
}
