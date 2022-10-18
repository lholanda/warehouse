package com.lhMeta.warehouse.services;

import org.springframework.stereotype.Service;

import com.lhMeta.warehouse.dtos.TarefaDto;

@Service
public class TarefaService {
	
	public TarefaDto criar(TarefaDto tarefaDto) {
		System.out.println("criar TarefaDto");
		return tarefaDto;
	}

}
