package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.DirigenteDTO;
import com.davide.azienda.dto.DivisioneDTO;
import com.davide.azienda.model.Dirigente;
import com.davide.azienda.model.Divisione;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.DirigenteRepository;
import com.davide.azienda.repository.DivisioneRepository;
import com.davide.azienda.repository.PersonaRepository;

@Service
public class DirigenteService {

    @Autowired
    private DirigenteRepository dirigenteRepository;

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private DivisioneRepository divisioneRepository;
    
    @Autowired
    private DivisioneService serviceDiv;

    public List<DirigenteDTO> findAllDir() {
        return dirigenteRepository.findAll()
                .stream()
                .map(ManualMapper::dirToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DirigenteDTO> findDirById(Long id) {
        return dirigenteRepository.findById(id).map(ManualMapper::dirToDTO);
    }

    public DirigenteDTO saveDir(DirigenteDTO dto) {
        Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
        Divisione divisione = divisioneRepository.findById(dto.getIdDivisione()).orElse(null);
        divisione.setDirigente(persona);
        DivisioneDTO divDto = ManualMapper.divToDTO(divisione);
        serviceDiv.saveDiv(divDto);
        divisione.setDirigente(null);
        Dirigente d = ManualMapper.dirToEntity(dto, persona, divisione);
        d.setIdPersona(null);
        return ManualMapper.dirToDTO(dirigenteRepository.save(d));
    }
    

    public boolean deleteDir(Long id) {
        return dirigenteRepository.findById(id).map(existing -> {
            dirigenteRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
