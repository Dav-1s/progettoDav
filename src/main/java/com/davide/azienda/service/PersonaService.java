package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.PersonaDTO;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaDTO> findAllPer() {
        return personaRepository.findAll()
                .stream()
                .map(ManualMapper::perToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PersonaDTO> findPerById(Long id) {
        return personaRepository.findById(id).map(ManualMapper::perToDTO);
    }

    public PersonaDTO savePer(PersonaDTO dto) {
        Persona persona = ManualMapper.perToEntity(dto);
        return ManualMapper.perToDTO(personaRepository.save(persona));
    }

    public Optional<PersonaDTO> updatePer(Long id, PersonaDTO dto) {
        return personaRepository.findById(id).map(existing -> {
            Persona updated = ManualMapper.perToEntity(dto);
            updated.setId(id);
            return ManualMapper.perToDTO(personaRepository.save(updated));
        });
    }

    public boolean deletePer(Long id) {
        return personaRepository.findById(id).map(existing -> {
            personaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
