package com.dncode.bdc.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisInput 
{	
	@NotBlank(message = "Nome do país é obrigatório")
	private String nome;
	
	@NotBlank(message = "Nome da capital é obrigatório")
	private String capital;
	
	@NotBlank(message = "Região do páis é obrigatório")
	private String regiao;
	
	@NotBlank(message = "Sub-região do país é obrigatório")
	private String subregiao;
	
	@NotNull(message = "Área do país é obrigatório")
	private BigDecimal area;
}