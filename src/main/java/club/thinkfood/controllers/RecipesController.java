package club.thinkfood.controllers;

import club.thinkfood.models.Image;
import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import club.thinkfood.repositories.ImageRepository;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecipesController {

    @Value(("${spoonacular.api}"))
    private String spoonacularApiKey;

    private RecipeRepository recipeDao;
    private UserRepository userDao;
    private ImageRepository imageDao;

    public RecipesController(RecipeRepository recipeDao, UserRepository userDao, ImageRepository imageDao) {
        this.recipeDao = recipeDao;
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/recipe")
    public String AllRecipes(Model model) {

        List<Recipe> recipes = recipeDao.findAll();

        model.addAttribute("recipes", recipes);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User currentUser = userDao.findUserById(id);
        model.addAttribute("user", user);
        System.out.println("user.getIsAdmin() = " + user.getIsAdmin());

        return "users/recipe";
    }

    @PostMapping("/recipe")
    public String ShowIngredients(){
        return "redirect:/users/ingredients";
    }

    @GetMapping("/vegetarian")
    public String getVeggies(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/vegetarian";
    }

    @PostMapping("/vegetarian")
    public String veggiesPage(){
        return "redirect: categories/vegetarian";
    }

    @GetMapping("/glutenFree")
    public String getGluten(Model model) {

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/glutenFree";
    }

    @PostMapping("/glutenFree")
    public String noGlutenPage(){
        return "redirect: categories/glutenFree";
    }

    @GetMapping("/healthFoods")
    public String healthyHelper(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/healthFoods";
    }

    @PostMapping("/healthFoods")
    public String homeOfHealth(){
        return "redirect: categories/healthFoods";
    }

    @GetMapping("/breakfast")
    public String breakfastBar(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/breakfast";
    }

    @PostMapping("/breakfast")
    public String bringTheBreakfast(){
        return "redirect: categories/breakfast";
    }

    @GetMapping("/vegan")
    public String vegans(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/vegan";
    }

    @PostMapping("/vegan")
    public String trueVegan(){
        return "redirect: categories/vegan";
    }

    @GetMapping("/popularFoods")
    public String cheap(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/popularFoods";
    }

    @PostMapping("/popularFoods")
    public String cheapFood(){
        return "redirect: categories/popularFoods";
    }

    @GetMapping("/pesce")
    public String peskyPesce(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/pesce";
    }


    @PostMapping("/pesce")
    public String pescePeople(){
        return "redirect: categories/pesce";
    }

    @GetMapping("/dairyFree")
    public String dairyDonts(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/dairyFree";
    }

    @PostMapping("/dairyFree")
    public String dairy(){
        return "redirect: categories/dairyFree";
    }

    @GetMapping("/primal")
    public String primalFood(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/primal";
    }

    @PostMapping("/primal")
    public String primalFoodie(){
        return "redirect: categories/primal";
    }

    @GetMapping("/lunch")
    public String lunchLounge(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/lunch";
    }

    @PostMapping("/lunch")
    public String lunchLauncher(){
        return "redirect: categories/lunch";
    }


    @GetMapping("/dinner")
    public String dinnerDiner(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "categories/dinner";
    }

    @PostMapping("/dinner")
    public String dinnerLauncher(){
        return "redirect: categories/dinner";
    }


    @GetMapping("/singleRecipe")
    public String singleDish(Model model){

        model.addAttribute("spoonkey", spoonacularApiKey);

        return "singleRecipe";
    }

    @PostMapping("/singleRecipe")
    public String singlePlate(){
        return "redirect: /singleRecipe";
    }


}
