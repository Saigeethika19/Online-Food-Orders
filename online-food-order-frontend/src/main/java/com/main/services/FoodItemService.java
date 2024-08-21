package com.main.services;

import java.util.List;

import com.main.entity.FoodItem;

public interface FoodItemService
{
//	create
	FoodItem createFoodItem(FoodItem foodItem);
	
	
//	Get Single Post
	List<FoodItem> getFoodItemByCategory(String category);
	FoodItem getFoodItemById(Integer foodItemId);
	FoodItem updateFoodItem(FoodItem postDto,Integer FoodItemId);

}
