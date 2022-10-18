package com.lhMeta.warehouse.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lhMeta.warehouse.models.CategoryModel;
import com.lhMeta.warehouse.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	
	public Optional<CategoryModel> findById(Long id) {
		return categoryRepository.findById(id);
	}

	public CategoryModel save(CategoryModel categoryModel) {
		return categoryRepository.save(categoryModel);
	}

}
