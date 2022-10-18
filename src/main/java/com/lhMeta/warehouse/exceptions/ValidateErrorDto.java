package com.lhMeta.warehouse.exceptions;

import java.util.Map;

public class ValidateErrorDto {
	
	private Map<String, String> error;

	public ValidateErrorDto(Map<String, String> error) {
		this.error = error;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}
	
}
