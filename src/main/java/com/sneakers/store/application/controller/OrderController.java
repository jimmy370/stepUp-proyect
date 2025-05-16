package com.sneakers.store.application.controller;

import com.sneakers.store.domain.model.Order;
import com.sneakers.store.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void saveOrder(@RequestParam("email") String email, @RequestBody List<String> idProducts){
        orderService.saveOrder(email,idProducts);
    }
}
