package com.lhMeta.warehouse.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/teste")
public class testeController {
	
	@GetMapping()
	public int testeDivPorZero() {
		return 9/0;
	}

}
