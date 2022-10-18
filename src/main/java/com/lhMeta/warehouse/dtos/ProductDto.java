package com.lhMeta.warehouse.dtos;

import javax.validation.constraints.NotBlank;

import com.lhMeta.warehouse.models.CategoryModel;

public class ProductDto {

	@NotBlank(message = "Name is mandatory")
	private String code;
	
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	private Double price;
	
	private CategoryModel category;

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}
	
	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", description=" + description + ", price=" + price + ", category="
				+ category.getDescription() + "]";
	}

	


	
	
	
}
