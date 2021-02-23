package com.vivusan.spring.repository;

import com.vivusan.spring.domain.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

}
