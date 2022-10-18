package com.lhMeta.warehouse.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhMeta.warehouse.models.CategoryModel;
import com.lhMeta.warehouse.services.CategoryService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/category")
public class CategoryController {
	
    final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public CategoryModel teste() throws InterruptedException {
		
		
		var categoryModel = categoryService.findById(2L).get();
		
		System.out.println(categoryModel.getDescription());
		Thread.sleep(8000);
		System.out.println(categoryModel);
		
		return categoryModel;
	}

}

