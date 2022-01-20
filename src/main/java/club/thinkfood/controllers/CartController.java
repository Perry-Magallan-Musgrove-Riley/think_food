package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/users/cart")
    public String getOrder(){
        return "/users/cart";
    }

}
