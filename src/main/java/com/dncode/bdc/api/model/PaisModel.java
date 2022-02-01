package com.dncode.bdc.api.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisModel extends RepresentationModel<PaisModel>
{
	private Long codigo;
	private String nome;
	private String capital;
	private String regiao;
	private String subregiao;
	private BigDecimal area;
}
