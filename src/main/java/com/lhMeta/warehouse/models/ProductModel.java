package com.lhMeta.warehouse.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUCTS")
public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true , length = 10)
	private String code;
	
	@Column(nullable = false, length = 30)
	private String description;
	
	@Column(nullable = false)
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryModel category;
	
	
	@Column(nullable = true)
	private LocalDateTime createDate;
	
	@Column(nullable = true)
	private LocalDateTime updateDate;
	
	public ProductModel() {
	}
	
	public ProductModel(Long id, String code, String description, Double price, LocalDateTime createDate, CategoryModel category) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.price = price;
		this.createDate = createDate;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
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
		ProductModel other = (ProductModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", code=" + code + ", description=" + description + ", price=" + price
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	

}
