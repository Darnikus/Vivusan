package com.vivusan.spring.service;


import com.vivusan.spring.domain.Food;
import com.vivusan.spring.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {


    private FoodRepository foodRepository;

    public Iterable<Food> list() {
        return foodRepository.findAll();
    }

    @Autowired
    public void setFoodRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void save(List<Food> foods) {
        foodRepository.saveAll(foods);
    }
}
