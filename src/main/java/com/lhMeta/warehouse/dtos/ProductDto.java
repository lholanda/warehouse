package com.lhMeta.warehouse.dtos;

import javax.validation.constraints.NotBlank;

public class ProductDto {

	@NotBlank(message = "Name is mandatory")
	private String code;
	
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	private Double price;

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", description=" + description + ", price=" + price + "]";
	}


	
	
	
}
