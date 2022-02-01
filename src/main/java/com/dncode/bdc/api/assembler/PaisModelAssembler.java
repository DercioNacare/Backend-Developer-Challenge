package com.dncode.bdc.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.dncode.bdc.api.controller.PaisController;
import com.dncode.bdc.api.model.PaisModel;
import com.dncode.bdc.domain.model.Pais;

@Component
public class PaisModelAssembler extends RepresentationModelAssemblerSupport<Pais, PaisModel>
{
	@Autowired 
	private ModelMapper modelMapper;
	
	public PaisModelAssembler() 
	{
		super(PaisController.class, PaisModel.class);
	}

	public PaisModel toModel(Pais pais)
	{
		PaisModel paisModel = modelMapper.map(pais, PaisModel.class);
		
		paisModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PaisController.class).actualizar(paisModel.getCodigo(), null)).withRel("actualizar"));
		
		
		return paisModel; 
	}
	
	public List<PaisModel> toCollectionModel(List<Pais> paises)
	{
		return paises.stream()
				.map((pais) -> toModel(pais))
				.collect(Collectors.toList());
	}
}