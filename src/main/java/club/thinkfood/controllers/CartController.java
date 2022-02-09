package club.thinkfood.controllers;


import club.thinkfood.models.User;
import club.thinkfood.repositories.UserRepository;
import club.thinkfood.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {
    private final UserRepository userDao;
    private final EmailService emailService;

    public CartController(UserRepository userDao, EmailService emailService) {
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/order")
    public String getOrder(@RequestParam List<String> ingredients, Model model) {
        model.addAttribute("ingredients", ingredients);
        //Now > can we turn it into a STATIC form with these ingredients that gets passed to this view
        //The view offers the user the form w/ ingredients to confirm > form sends a POST to /order and triggers methods below
        //Methods below will take in said-form and POST the ingredients now to DB?
        return "users/order";
    }

    @GetMapping("/email-confirm")
    public String confirmEmail(){
        return "recipes/email-confirm";
    }

//    @PostMapping("/order")
//    public String Order(@RequestParam List<String> ingredients){
//        System.out.println(ingredients);
//        return "redirect:/profile";
//http://localhost:8080/order?ingredients=1%2F4+tsp+Baking+Powder&ingredients=1%2F4+tsp+Baking+Soda&ingredients=3%2F4+C+Butter&ingredients=1%2F2+C+Cornstarch&ingredients=1+Egg&ingredients=1+1%2F2+C+All-Purpose+Flour&ingredients=1+drop+of+pink+food+coloring+%28optional%29&ingredients=1%2F2+%E2%80%93+3%2F4+tsp+Pink+Lemonade+Kool-Aid&ingredients=1%2F4+C+Powdered+Sugar&ingredients=1+1%2F4+C+Sugar
//    }

    @PostMapping("/order")
    public String Order(@RequestParam(name = "ingredient") List<String> ingredients, @ModelAttribute User user) {
        User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println("ingredient = " + ingredients);
        String list = String.join(" ", ingredients);
        System.out.println("ingredient = " + list);

        User user2 = userDao.findUserById(user1.getId());


//        String list = arrayOfStrings(ingredients);
        emailService.prepareAndSend(user2, "Shopping List", list);

        return "redirect:/email-confirm";


    }

//    public String arrayOfStrings(List<String> ingredients) {
//            String stringArray[] = (String[]) ingredients.toArray();
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0; i < stringArray.length; i++) {
//                sb.append(stringArray[i]);
//            }
//            String str = sb.toString();
//            return str;
//    }
}
