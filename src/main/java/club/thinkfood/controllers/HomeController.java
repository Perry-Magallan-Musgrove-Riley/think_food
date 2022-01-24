package club.thinkfood.controllers;


import club.thinkfood.models.Image;
import club.thinkfood.models.Recipe;
import club.thinkfood.repositories.RecipeRepository;
import club.thinkfood.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final RecipeRepository recipeDao;
    private final UserRepository userDao;

    public HomeController(RecipeRepository recipeDao, UserRepository userDao){
        this.recipeDao = recipeDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String HomePage(){
        return "index";
    }

    @PostMapping("/")
    public String SignUp(){
        //later setup authentication
        return "redirect:/users/sign-up";
    }

    @GetMapping("/recipe-search/")
    public String recipeSearch(Model model, @RequestParam(name = "search") String search){

        System.out.println("search = " + search);
//        List<Recipe> recipes1 = userDao.findUserByUsernameIsLike((club.thinkfood.models.User) user);
//        List<Recipe> recipes2 = recipeDao.findRecipesByDescriptionIsLike(search);
        List<Recipe> recipes = recipeDao.findRecipesByTitleContains(search);

        System.out.println("recipes.get(0).getTitle() = " + recipes.get(0).getTitle());
        model.addAttribute("recipes", recipes);
//        model.addAttribute("recipes", recipes1);
//        model.addAttribute("recipes", recipes2);
        return "recipe-search";
    }
//
//    @PostMapping("/recipe-search/{search}")
//    public String getSearch(@PathVariable(name = "search") String search){
//
//        return "redirect:/recipe-search/" + search;
//    }

    @GetMapping("/questionnaire")
    public String getQuestionnaire(){
        return "questionnaire";
    }

    @PostMapping("/questionnaire")
    public String Questionnaire(){
        return "redirect:/questionnaire";
    }

}
