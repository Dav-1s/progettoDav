package com.davide.azienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davide.azienda.converter.PersonaConverter;
import com.davide.azienda.dto.PersonaDto;
import com.davide.azienda.model.Persona;
import com.davide.azienda.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public List<PersonaDto> getAllPersona() {
		List<Persona> listPersona = personaRepository.findAll();
		List<PersonaDto> listDto = new ArrayList<PersonaDto>();
		PersonaDto dto = new PersonaDto();
		for (Persona persona : listPersona) {
			PersonaConverter converter = new PersonaConverter();
			dto = converter.convertToDto(persona);
			listDto.add(dto);
		}
		return listDto;
		
	}
	
	public PersonaDto getPersona(int id) {
		Optional<Persona> persona = this.personaRepository.findById(id);
		PersonaDto dto = new PersonaDto();
		PersonaConverter converter = new PersonaConverter();
		if (persona.isPresent()) {
			dto = converter.convertToDto(persona.get());
			return dto;
		} else {
			return null;
		}
	}
	
	public void addPersona(PersonaDto dto) {
		Persona persona = new Persona();
		PersonaConverter converter = new PersonaConverter();
		persona = converter.convertToEntity(dto);
		personaRepository.save(persona);
		}
	
	public void updatePersona(int id, PersonaDto dto) {
		Optional<Persona> existingPersona = personaRepository.findById(id);
		if (existingPersona.isPresent()) {
		    Persona persona = existingPersona.get();
		    persona.setNome(dto.getNome());
		    persona.setCognome(dto.getCognome());
		    persona.setAnniAnzianitaLavorativa(dto.getAnniAnzianitaLavorativa());
		    persona.setRetribuzioneAnnua(dto.getRetribuzioneAnnua());
		    personaRepository.save(persona);
		}
	}

	public void deletePersona(int id) {
		personaRepository.deleteById(id);
	}

}
