package com.lhMeta.warehouse.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhMeta.warehouse.dtos.TarefaDto;
import com.lhMeta.warehouse.services.TarefaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/task")
public class TarefaController {
	
	final TarefaService tarefaService;
	
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}


	@PostMapping
	public TarefaDto criar(@RequestBody @Valid TarefaDto tarefaDto) {
		return tarefaService.criar(tarefaDto);
	}
	
	

}
