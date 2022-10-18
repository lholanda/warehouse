package com.lhMeta.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhMeta.warehouse.models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
	
	boolean existsByCode(String code);

	//abstract Page<ProductModel> findAllPage(Pageable pageable);
	
}
