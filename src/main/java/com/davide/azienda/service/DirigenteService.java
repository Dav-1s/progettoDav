package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.DirigenteDTO;
import com.davide.azienda.model.Dirigente;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.DirigenteRepository;
import com.davide.azienda.repository.PersonaRepository;

@Service
public class DirigenteService {

    @Autowired
    private DirigenteRepository dirigenteRepository;

    @Autowired
    private PersonaRepository personaRepository;

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
        Dirigente d = ManualMapper.dirToEntity(dto, persona);
        return ManualMapper.dirToDTO(dirigenteRepository.save(d));
    }
    

    public boolean deleteDir(Long id) {
        return dirigenteRepository.findById(id).map(existing -> {
            dirigenteRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
