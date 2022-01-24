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

    @GetMapping("/vegetarian")
    public String getVeggies(){
        return "categories/vegetarian";
    }

    @PostMapping("/vegetarian")
    public String veggiesPage(){
        return "redirect: categories/vegetarian";
    }

    @GetMapping("/glutenFree")
    public String getGluten(){
        return "categories/glutenFree";
    }

    @PostMapping("/glutenFree")
    public String noGlutenPage(){
        return "redirect: categories/glutenFree";
    }

    @GetMapping("/keto")
    public String getKetoKool(){
        return "categories/keto";
    }

    @PostMapping("/keto")
    public String ketoKool(){
        return "redirect: categories/keto";
    }

    @GetMapping("/lactoVeg")
    public String noEggVeg(){
        return "categories/lactoVeg";
    }

    @PostMapping("/lactoVeg")
    public String getNoEggVeg(){
        return "redirect: categories/lactoVeg";
    }

    @GetMapping("/vegan")
    public String vegans(){
        return "categories/vegan";
    }

    @PostMapping("/vegan")
    public String trueVegan(){
        return "redirect: categories/vegan";
    }

    @GetMapping("/ovoVeg")
    public String ovoVeg(){
        return "categories/ovoVeg";
    }

    @PostMapping("/ovoVeg")
    public String theRealOvo(){
        return "redirect: categories/ovoVeg";
    }

    @GetMapping("/pesce")
    public String peskyPesce(){
        return "categories/pesce";
    }


    @PostMapping("/pesce")
    public String pescePeaople(){
        return "redirect: categories/pesce";
    }

    @GetMapping("/paleo")
    public String paleoPage(){
        return "categories/paleo";
    }

    @PostMapping("/paleo")
    public String paleLeo(){
        return "redirect: categories/paleo";
    }

    @GetMapping("/primal")
    public String primalFood(){
        return "categories/primal";
    }

    @PostMapping("/primal")
    public String primalFoodie(){
        return "redirect: categories/primal";
    }

    @GetMapping("/whole30")
    public String wholeFoodies(){
        return "categories/whole30";
    }

    @PostMapping("/whole30")
    public String wholeFoods(){
        return "redirect: categories/whole30";
    }


}
