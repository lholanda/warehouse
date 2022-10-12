package com.lhMeta.warehouse.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lhMeta.warehouse.models.ProductModel;
import com.lhMeta.warehouse.repositories.ProductRepository;

@Service
public class ProductService {
	
	// ponto de injecao - final + constructor
	final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional
	public ProductModel save(ProductModel productModel) {	
		return productRepository.save(productModel);
	}

	public boolean existsByCode(String code) {
		return productRepository.existsByCode(code);
	}

	
	public List<ProductModel> findAll() {
		return productRepository.findAll();
	}
	
	
	public Page<ProductModel> findAllWithPage(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Optional<ProductModel> findById(Long id) {	
		return productRepository.findById(id);
	}

	@Transactional
	public void deleteProduct(ProductModel productModel) {
		productRepository.delete(productModel);		
	}


}
