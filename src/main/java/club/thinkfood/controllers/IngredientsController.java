package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IngredientsController {

    @GetMapping("/ingredients")
    public String recipeIngredients(){
        return "/users/ingredients";
    }

}
