package com.dncode.bdc.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dncode.bdc.api.model.input.PaisInput;
import com.dncode.bdc.domain.model.Pais;

@Component
public class PaisInputDisassembler 
{
	@Autowired 
	private ModelMapper modelMapper;
	
	public Pais toDomainObject(PaisInput paisInput)
	{
		return modelMapper.map(paisInput, Pais.class);
	}
}