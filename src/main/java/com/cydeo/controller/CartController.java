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

    @RequestMapping("/cart-list")
    public String cartListPage(Model model){

        model.addAttribute("cartList",CART_LIST);

        return "cart/cart-list";
    }

    @RequestMapping("/cart-list/{cartId}")
    public String cartListPage2(Model model , @PathVariable String cartId){

        CartServiceImpl cartService = new CartServiceImpl();

        model.addAttribute("cartItemList", cartService.retrieveCartDetail(UUID.fromString(cartId)));


        return "cart/cart-detail";


    }

}
