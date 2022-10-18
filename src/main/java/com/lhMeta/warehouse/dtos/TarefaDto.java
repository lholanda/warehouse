package com.lhMeta.warehouse.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TarefaDto {
	
	@NotNull(message="this title cannot be null")
	@Size(min=5, message="must be at least 5 characters long")
	private String title;
	
	@NotNull(message="this description cannot be null")
	@NotEmpty(message="this description cannot empty")
	private String description;
	
	@Email(message="Invalid email")
	@NotNull(message="Cannot empty")
	private String email;
	
	@Min(value=1)
	@Max(value=5, message="Maxim value = 5")
	@NotNull(message="Cannot be null")
	private Integer priority;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
