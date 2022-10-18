package com.lhMeta.warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhMeta.warehouse.models.CategoryModel;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

}
