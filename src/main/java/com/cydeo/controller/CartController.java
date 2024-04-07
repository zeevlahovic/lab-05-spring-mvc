package com.cydeo.controller;

import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.UUID;
import static com.cydeo.service.impl.CartServiceImpl.CART_LIST;


@Controller
public class CartController {

   private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart-list")
    public String cartListPage(Model model){

        model.addAttribute("cartList",CART_LIST);

        return "cart/cart-list";
    }

    @RequestMapping("/cart-list/{cartId}")
    public String cartListPage2(Model model , @PathVariable UUID cartId){


        model.addAttribute("cartItemList", cartService.retrieveCartDetail(cartId));


        return "cart/cart-detail";


    }

}
