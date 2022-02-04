package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @GetMapping("/order")
    public String getOrder(@RequestParam List<String> ingredients, Model model){
        model.addAttribute("ingredients", ingredients);
        //Now > can we turn it into a STATIC form with these ingredients that gets passed to this view
        //The view offers the user the form w/ ingredients to confirm > form sends a POST to /order and triggers methods below
        //Methods below will take in said-form and POST the ingredients now to DB?
        return "/users/order";
    }

//    @PostMapping("/order")
//    public String Order(@RequestParam List<String> ingredients){
//        System.out.println(ingredients);
//        return "redirect:/profile";
//http://localhost:8080/order?ingredients=1%2F4+tsp+Baking+Powder&ingredients=1%2F4+tsp+Baking+Soda&ingredients=3%2F4+C+Butter&ingredients=1%2F2+C+Cornstarch&ingredients=1+Egg&ingredients=1+1%2F2+C+All-Purpose+Flour&ingredients=1+drop+of+pink+food+coloring+%28optional%29&ingredients=1%2F2+%E2%80%93+3%2F4+tsp+Pink+Lemonade+Kool-Aid&ingredients=1%2F4+C+Powdered+Sugar&ingredients=1+1%2F4+C+Sugar
//    }

    @PostMapping("/order")
    public String Order(@RequestParam List<String> ingredients){
        System.out.println(ingredients);

        return "redirect:/order";

    }

}
