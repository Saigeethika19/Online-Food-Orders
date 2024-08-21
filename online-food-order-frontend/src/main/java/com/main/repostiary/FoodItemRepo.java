package com.main.repostiary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
	List<FoodItem>findByCategory(String category);
}
