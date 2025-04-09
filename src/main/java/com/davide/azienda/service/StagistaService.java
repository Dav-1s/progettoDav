package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.StagistaDTO;
import com.davide.azienda.model.Persona;
import com.davide.azienda.model.Stagista;
import com.davide.azienda.repository.PersonaRepository;
import com.davide.azienda.repository.StagistaRepository;

@Service
public class StagistaService {

    @Autowired
    private StagistaRepository stagistaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<StagistaDTO> findAllSta() {
        return stagistaRepository.findAll()
                .stream()
                .map(ManualMapper::staToDTO)
                .collect(Collectors.toList());
    }

    public Optional<StagistaDTO> findStaById(Long id) {
        return stagistaRepository.findById(id).map(ManualMapper::staToDTO);
    }

    public StagistaDTO saveSta(StagistaDTO dto) {
        Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
        Stagista s = ManualMapper.staToEntity(dto, persona);
        s.setIdPersona(null);
        stagistaRepository.deleteById(persona.getId());
        return ManualMapper.staToDTO(stagistaRepository.save(s));
    }
    

    public boolean deleteSta(Long id) {
        return stagistaRepository.findById(id).map(existing -> {
            stagistaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
