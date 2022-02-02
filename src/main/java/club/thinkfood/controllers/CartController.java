package club.thinkfood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @GetMapping("/order")
    public String getOrder(){
        return "users/order";
    }

    @PostMapping("/order")
    public String Order(){
        return "redirect: users/order";

    }

}
