package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipesController {

    @GetMapping("/recipe")
    public String AllRecipes(){
        return "/users/recipe";
    }

    @PostMapping("/recipe")
    public String ShowIngredients(){
        return "redirect:/users/ingredients";
    }

}
