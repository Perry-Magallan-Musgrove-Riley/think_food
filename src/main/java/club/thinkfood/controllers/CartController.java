package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/users/order")
    public String getOrder(){
        return "/users/order";
    }

}
