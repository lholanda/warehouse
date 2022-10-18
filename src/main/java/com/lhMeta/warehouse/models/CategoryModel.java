package com.lhMeta.warehouse.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_CATEGORY")
public class CategoryModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<ProductModel> products  = new ArrayList<>();;

	public CategoryModel() {
	}
	
	public CategoryModel(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<ProductModel> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryModel other = (CategoryModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CategoryModel [id=" + id + ", description=" + description + ", products=" + products;
	}
	
	
	
	

	
	

	
	
}