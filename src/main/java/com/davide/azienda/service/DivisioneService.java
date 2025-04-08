package com.davide.azienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.ManualMapper;
import com.davide.azienda.dto.DivisioneDTO;
import com.davide.azienda.model.Divisione;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.DivisioneRepository;
import com.davide.azienda.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DivisioneService {

    @Autowired
    private DivisioneRepository divisioneRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<DivisioneDTO> findAllDiv() {
        return divisioneRepository.findAll()
                .stream()
                .map(ManualMapper::divToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DivisioneDTO> findDivById(Long id) {
        return divisioneRepository.findById(id)
                .map(ManualMapper::divToDTO);
    }

    public DivisioneDTO saveDiv(DivisioneDTO dto) {
        Persona dirigente = null;
        if (dto.getIdDirigente() != null) {
            dirigente = personaRepository.findById(dto.getIdDirigente()).orElse(null);
        }
        Divisione divisione = ManualMapper.divToEntity(dto, dirigente);
        return ManualMapper.divToDTO(divisioneRepository.save(divisione));
    }

    public Optional<DivisioneDTO> updateDiv(Long id, DivisioneDTO dto) {
        return divisioneRepository.findById(id).map(existing -> {
            Persona dirigente = null;
            if (dto.getIdDirigente() != null) {
                dirigente = personaRepository.findById(dto.getIdDirigente()).orElse(null);
            }
            Divisione updated = ManualMapper.divToEntity(dto, dirigente);
            updated.setId(id);
            return ManualMapper.divToDTO(divisioneRepository.save(updated));
        });
    }

    public boolean deleteDiv(Long id) {
        return divisioneRepository.findById(id).map(existing -> {
            divisioneRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
