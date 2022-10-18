package com.lhMeta.warehouse;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lhMeta.warehouse.models.CategoryModel;
import com.lhMeta.warehouse.models.ProductModel;
import com.lhMeta.warehouse.services.CategoryService;
import com.lhMeta.warehouse.services.ProductService;

// exclude tira do log a password do security
//@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})

@SpringBootApplication
public class WarehouseApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	

	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------");
		System.out.println("Spring Boot 2022 !!!");
		System.out.println("-------------------");	
		
		CategoryModel cat1 = new CategoryModel(null, "Electronics");
		CategoryModel cat2 = new CategoryModel(null, "Hammers");
		
		// para alimentar a criacao
		LocalDateTime createDate = LocalDateTime.now(ZoneId.of("UTC"));

		ProductModel p1 = new ProductModel(null, "HA37", "Lump Hammer Fibreglass", 12.86, createDate, cat2);
		ProductModel p2 = new ProductModel(null, "986181", "18V SDS Plus Hammer Drill", 75.33,createDate, cat2);
		ProductModel p3 = new ProductModel(null, "gt56","Machete & Sheath",7.14, createDate, cat1);
		ProductModel p4 = new ProductModel(null, "270120","2hp Air Compressor 50Ltr",265.38, createDate, cat1);
		
		cat1.getProducts().addAll(Arrays.asList(p3, p4));
		cat2.getProducts().addAll(Arrays.asList(p1, p2));
		
		categoryService.save(cat1);
		categoryService.save(cat2);
		
		productService.save(p1);
		productService.save(p2);
		productService.save(p3);
		productService.save(p4);

	}

}
