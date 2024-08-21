package com.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.main.entity.FoodItem;
import com.main.repostiary.FoodItemRepo;
import com.main.services.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService
{
	@Autowired
	private FoodItemRepo foodItemRepo;

	@Override
	public FoodItem createFoodItem(FoodItem foodItem) {
		foodItem.setImage("default.png");
		FoodItem savedFoodItem = foodItemRepo.save(foodItem);
		return savedFoodItem;
	}


	@Override
	public List<FoodItem> getFoodItemByCategory(String category) {
		
		List<FoodItem> findByCategory = foodItemRepo.findByCategory(category);
		return findByCategory;
	}


	@Override
	public FoodItem getFoodItemById(Integer foodItemId) {
		FoodItem foodItem = foodItemRepo.findById(foodItemId).orElse(null);
		return foodItem;
	}


	 public FoodItem updateFoodItem(FoodItem foodItem, Integer foodItemId) {
	        FoodItem foodItemById = foodItemRepo.findById(foodItemId).orElse(null);
	        if (foodItemById != null) {
	            foodItemById.setName(foodItem.getName());
	            foodItemById.setCategory(foodItem.getCategory());
	            foodItemById.setImage(foodItem.getImage());
	            return foodItemRepo.save(foodItemById);
	        } else {
	            throw new RuntimeException("FoodItem not found with ID: " + foodItemId);
	        }
	    }
}
