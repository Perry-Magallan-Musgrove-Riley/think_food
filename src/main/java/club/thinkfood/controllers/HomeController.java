package club.thinkfood.controllers;

import club.thinkfood.models.Recipe;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Value(("${spoonacular.api}"))
    private String spoonacularApiKey;

    private final RecipeRepository recipeDao;
    private final UserRepository userDao;

    public HomeController(RecipeRepository recipeDao, UserRepository userDao){
        this.recipeDao = recipeDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute("spoonkey", spoonacularApiKey);
        return "home";
    }

    @PostMapping("/")
    public String SignUp(){
        return "redirect:/users/sign-up";
    }

    @GetMapping("/recipe-search/")
    public String recipeSearch(Model model, @RequestParam(name = "search") String search){

        System.out.println("search = " + search);
        List<Recipe> recipes = recipeDao.findRecipesByTitleContains(search);

        System.out.println("recipes.get(0).getTitle() = " + recipes.get(0).getTitle());
        model.addAttribute("recipes", recipes);
        return "recipe-search";
    }

    @GetMapping("/questionnaire")
    public String getQuestionnaire(){
        return "questionnaire";
    }

    @PostMapping("/questionnaire")
    public String Questionnaire(){
        return "redirect:/questionnaire";
    }

}
