package club.thinkfood.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Value(("${spoonacular.api}"))
    private String spoonacularApiKey;

    @GetMapping("/")
    public String HomePage(Model model){
        model.addAttribute("spoonkey", spoonacularApiKey);
        return "index";
    }

    @PostMapping("/")
    public String SignUp(){
        //later setup authentication
        return "redirect:/users/sign-up";
    }

    @GetMapping("/recipe-search/{search}")
    public String recipeSearch(@PathVariable String search, Model model){
        model.addAttribute("search", search);
        return "recipe-search";
    }

    @PostMapping("/recipe-search/{search}")
    public String getSearch(@RequestParam(name = "search") String search){

        return "redirect:/recipe-search/" + search;
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
