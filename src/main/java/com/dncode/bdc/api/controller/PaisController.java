package com.dncode.bdc.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dncode.bdc.api.assembler.PaisModelAssembler;
import com.dncode.bdc.api.disassembler.PaisInputDisassembler;
import com.dncode.bdc.api.model.PaisModel;
import com.dncode.bdc.api.model.input.PaisInput;
import com.dncode.bdc.domain.service.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController 
{
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private PaisModelAssembler paisModelAssembler;
	
	@Autowired
	private PaisInputDisassembler paisInputDisassembler;
	
	@GetMapping
	public List<PaisModel> listar(Sort sort)
	{
		return paisModelAssembler.toCollectionModel(paisService.listar(sort));
	}
	
	@GetMapping("/{codigo}")
	public PaisModel buscar(@PathVariable("codigo") Long codigo)
	{
		return paisModelAssembler.toModel(paisService.buscar(codigo)); 
	}
	
	@PostMapping @ResponseStatus(HttpStatus.CREATED)
	public PaisModel salvar(@Valid @RequestBody PaisInput paisInput)
	{
		return paisModelAssembler.toModel(paisService.salvar(paisInputDisassembler.toDomainObject(paisInput)));
	}
	
	@PutMapping("/{codigo}") 
	public PaisModel actualizar(@PathVariable("codigo") Long codigo, @RequestBody PaisInput paisInput)	
	{
		return paisModelAssembler.toModel(paisService.actualizar(codigo, paisInputDisassembler.toDomainObject(paisInput)));
	}	
	
	@DeleteMapping("/{codigo}") 
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void remover(@PathVariable("codigo") Long codigo)
	{
		paisService.remover(codigo);
	}
}