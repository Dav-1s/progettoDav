package com.davide.azienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davide.azienda.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
