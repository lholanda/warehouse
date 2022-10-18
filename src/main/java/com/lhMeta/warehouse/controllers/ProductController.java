package com.lhMeta.warehouse.controllers;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhMeta.warehouse.dtos.ProductDto;
import com.lhMeta.warehouse.models.ProductModel;
import com.lhMeta.warehouse.services.ProductService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductController {

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Value("${java.teste}")
	private String javaTeste;
	


	@PostMapping
	public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDto productDto) {

		// verificacoes colocar em custonValidator - dica
		if (productService.existsByCode(productDto.getCode())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Code is already in use !");
		}

		ProductModel productModel = new ProductModel();
		// converter o DTO to Model
		BeanUtils.copyProperties(productDto, productModel);
		
		
		productModel.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));

		productModel = productService.save(productModel);

		return ResponseEntity.status(HttpStatus.CREATED).body(productModel);
	}

	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<ProductModel>> getAllProductsPage(@PageableDefault(page=0, size= 1) Pageable pageable) {
	
		System.out.println(javaTeste);
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAllWithPage(pageable));
	}

	@GetMapping("/mic/{id}")
	public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") Long id) {
		Optional<ProductModel> productModelOptional = productService.findById(id);
		
		ProductModel produto = productService.achaById(id);
		
		System.out.println(produto);
		
		if (!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found !!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
		}
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getProduct(@PathVariable(value = "id") Long id) {
		
		ProductModel produto = productService.achaById(id);
	
		return ResponseEntity.status(HttpStatus.OK).body(produto);

	}
	
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {
		Optional<ProductModel> productModelOptional = productService.findById(id);

		if (!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found !!!");
		} else {
			productService.deleteProduct(productModelOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Long id,
			@RequestBody @Valid ProductDto productDto) {

		ProductModel productModel = new ProductModel();
		Optional<ProductModel> productModelOptional = productService.findById(id);
		productModel = productModelOptional.get();

		if (!productModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found !!!");
		} else {
			System.out.println(productDto);
			put_model2(id, productDto);
			//put_model2(id, productDto);
			
			return ResponseEntity.status(HttpStatus.OK).body(productModel);
		}
	}
	
	
	// duas frmas de fazer o put
	public void put_model1(Long id, ProductDto productDto) {
		Optional<ProductModel> productModelOptional = productService.findById(id);
		ProductModel productModel = productModelOptional.get();
			// preencher as informacoes informadas pelo Dto, setar cada campo que vai ser
			// atualizado
			// id - no
			// createDate - no
			// updateDate - yes
			productModel.setCode(productDto.getCode());
			productModel.setDescription(productDto.getDescription());
			productModel.setPrice(productDto.getPrice());
			productModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
			
			productModel = productService.save(productModel);
	}
	
	public void put_model2(Long id, ProductDto productDto) {
	
		Optional<ProductModel> productModelOptional = productService.findById(id);
		ProductModel productModel = productModelOptional.get();
		
		// converter o DTO to Model
		BeanUtils.copyProperties(productDto, productModel);
		productModel.setId(productModel.getId());
		productModel.setCreateDate(productModel.getCreateDate());
		productModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

		productModel = productService.save(productModel);
		
		
	}
	
	
	
}

