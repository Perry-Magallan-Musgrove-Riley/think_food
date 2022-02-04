package club.thinkfood.controllers;

import club.thinkfood.models.Image;
import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.ImageRepository;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;
    private final ImageRepository imageDao;

    public ProfileController(UserRepository userDao, RecipeRepository recipeDao, ImageRepository imageDao) {

        this.userDao = userDao;
        this.recipeDao = recipeDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findUserById(loggedInUser.getId());

        List<Recipe> userRecipes = userDao.findUserById(loggedInUser.getId()).getMyRecipes();

        model.addAttribute("username", currentUser.getUsername());
        model.addAttribute("bio", currentUser.getBio());
        model.addAttribute("profileImg", currentUser.getImg().getImg_path());

//       model.addAttribute("recipes", recipes);
//        System.out.println(recipes);
        model.addAttribute("userRecipes", userRecipes);
        System.out.println("currentUser = " + currentUser.getIsAdmin());
        System.out.println("loggedInUser = " + loggedInUser.getIsAdmin());

        return "users/profile";
    }



//    @GetMapping("/profile")
//    public String saveRecipe(@RequestParam List<Recipe> recipes, Model model){
//        System.out.println(recipes);
//        model.addAttribute("recipes", recipes);
//        return "users/profile";
//    }

    @PostMapping("/profile")
    public String showProfile(@RequestParam (name="recipeId") Long recipeId){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findUserById(loggedInUser.getId());

        System.out.println(recipeId);
//        Image image = new Image();
//        Recipe recipe = new Recipe();
//        image.setImg_path(recipeImage);
//        recipe.setTitle(title);
//        recipe.setDescription(instructions);
//        List<Recipe> savedRecipe = new List<Recipe>();

//        currentUser.setMyRecipes(currentUser.getMyRecipes().add(recipe));
//        imageDao.save(image);
//        recipeDao.save(recipe);
//        userDao.save(currentUser);
//
        return "redirect:/profile";
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
    public String editRecipe(@PathVariable long id, Model model) {

        Recipe editRecipe = recipeDao.getById(id);

        model.addAttribute("recipeToEdit", editRecipe);

        return "recipes/editRecipe";
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
