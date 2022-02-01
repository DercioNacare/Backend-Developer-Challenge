package com.dncode.bdc.domain.exception;

public class PaisNaoEncontradoException extends EntidadeNaoEncontradaException
{
	public PaisNaoEncontradoException(String mensagem) 
	{
		super(mensagem);
	}
	
	public PaisNaoEncontradoException(Long codigo)
	{
		this(String.format("País de código %d não encontrado", codigo));
	}
	private static final long serialVersionUID = 1L;
}
