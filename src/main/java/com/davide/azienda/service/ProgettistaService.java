package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.ProgettistaDTO;
import com.davide.azienda.model.Divisione;
import com.davide.azienda.model.Persona;
import com.davide.azienda.model.Progettista;
import com.davide.azienda.repository.DivisioneRepository;
import com.davide.azienda.repository.PersonaRepository;
import com.davide.azienda.repository.ProgettistaRepository;

@Service
public class ProgettistaService {

    @Autowired
    private ProgettistaRepository progettistaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DivisioneRepository divisioneRepository;

    public List<ProgettistaDTO> findAllPro() {
        return progettistaRepository.findAll()
                .stream()
                .map(ManualMapper::proToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProgettistaDTO> findProById(Long id) {
        return progettistaRepository.findById(id).map(ManualMapper::proToDTO);
    }

    public ProgettistaDTO savePro(ProgettistaDTO dto) {
        Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
        Divisione divisione = divisioneRepository.findById(dto.getIdDivisione()).orElse(null);
        Progettista p = ManualMapper.proToEntity(dto, persona, divisione);
        return ManualMapper.proToDTO(progettistaRepository.save(p));
    }

    public boolean deletePro(Long id) {
        return progettistaRepository.findById(id).map(existing -> {
            progettistaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
