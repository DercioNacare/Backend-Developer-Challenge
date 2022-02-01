package com.dncode.bdc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dncode.bdc.domain.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> 
{

}