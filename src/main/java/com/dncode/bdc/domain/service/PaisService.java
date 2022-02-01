package com.dncode.bdc.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dncode.bdc.domain.exception.PaisNaoEncontradoException;
import com.dncode.bdc.domain.model.Pais;
import com.dncode.bdc.domain.repository.PaisRepository;

@Service
public class PaisService 
{
	@Autowired
	private PaisRepository paisRepository;
	
	@Transactional
	public Pais salvar(Pais pais)
	{
		return paisRepository.save(pais);
	}
	
	@Transactional
	public Pais actualizar(Long codigo, Pais pais)
	{
		Pais paisSalvo = buscarOuFalhar(codigo);
		BeanUtils.copyProperties(pais, paisSalvo, "codigo");
		return paisRepository.save(paisSalvo);	
	}
	
	@Transactional
	public void remover(Long codigo) 
	{
		try
		{
			paisRepository.deleteById(codigo);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new PaisNaoEncontradoException(codigo);
		}
	}
	
	public List<Pais> listar(Sort sort)
	{
		return paisRepository.findAll(sort);
	}
	
	public Pais buscar(Long codigo)
	{
		return buscarOuFalhar(codigo);
	}
	
	private Pais buscarOuFalhar(Long codigo)
	{
		return paisRepository.findById(codigo).orElseThrow(() -> new PaisNaoEncontradoException(codigo));
	}
}