package com.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.entity.FoodItem;
import com.main.services.FileService;
import com.main.services.FoodItemService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/foodItem")
public class FoodItemController {

	@Autowired
	private FoodItemService foodItemService;
	@Value("${project.image}")
	private String path;
	
	@Autowired
	private FileService fileService;
	@PostMapping("/createFoodItem")
	public ResponseEntity<FoodItem>createFoodItem(@RequestBody FoodItem foodItem)
	{
		FoodItem createFoodItem = foodItemService.createFoodItem(foodItem);
		return new ResponseEntity<FoodItem>(createFoodItem,HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<FoodItem>> getFoodItemsByCategory(@PathVariable String category)
	{
		List<FoodItem> foodItemByCategory = foodItemService.getFoodItemByCategory(category);
		return new ResponseEntity<List<FoodItem>>(foodItemByCategory,HttpStatus.OK);
	}
	@GetMapping("/foodId/{foodItemId}")
	public ResponseEntity<FoodItem> getFoodItemsById(@PathVariable Integer foodItemId)
	{
		 FoodItem foodItemById = foodItemService.getFoodItemById(foodItemId);
		return new ResponseEntity<FoodItem>(foodItemById,HttpStatus.OK);
	}
	
	

	
	@PostMapping("/image/upload/{foodItemId}")
	public ResponseEntity<FoodItem>uploadFoodItemImage(@RequestParam("image")MultipartFile fileimage,@PathVariable Integer foodItemId) throws IOException{
	
	
	FoodItem foodItem = foodItemService.getFoodItemById(foodItemId);
	String fileName = this.fileService.uploadImage(path, fileimage);
	foodItem.setImage(fileName);
	FoodItem updateFoodItem = foodItemService.updateFoodItem(foodItem, foodItemId);
	
	return new  ResponseEntity<FoodItem>(updateFoodItem,HttpStatus.OK);
	
	}

	
	
	

	
	
	
	//----------------------------Method to Serve files-------------------
	@GetMapping(value = "/food/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName")String imageName
		,HttpServletResponse response) throws IOException {
	
	
	
	InputStream resources = this.fileService.getResources(path, imageName);
	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	StreamUtils.copy(resources, response.getOutputStream());
	
	}
}
