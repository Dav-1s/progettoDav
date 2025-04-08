package com.davide.azienda.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.AmministratoreDTO;
import com.davide.azienda.model.Amministratore;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.AmministratoreRepository;
import com.davide.azienda.repository.PersonaRepository;

@Service
public class AmministratoreService {

    @Autowired
    private AmministratoreRepository amministratoreRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<AmministratoreDTO> findAllAmm() {
        return amministratoreRepository.findAll()
                .stream()
                .map(ManualMapper::ammToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AmministratoreDTO> findAmmById(Long id) {
        return amministratoreRepository.findById(id).map(ManualMapper::ammToDTO);
    }

    public AmministratoreDTO saveAmm(AmministratoreDTO dto) {
        Persona persona = personaRepository.findById(dto.getIdPersona()).orElse(null);
        Amministratore a = ManualMapper.ammToEntity(dto, persona);
        return ManualMapper.ammToDTO(amministratoreRepository.save(a));
    }
    

    public boolean deleteAmm(Long id) {
        return amministratoreRepository.findById(id).map(existing -> {
            amministratoreRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}

