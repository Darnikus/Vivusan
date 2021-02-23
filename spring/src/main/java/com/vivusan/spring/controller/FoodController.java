package com.vivusan.spring.controller;


import com.vivusan.spring.domain.Food;
import com.vivusan.spring.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
    private FoodService foodService;

    @Autowired
    public void setFoodService(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("list")
    public Iterable<Food> list() {
        return foodService.list();
    }
}
