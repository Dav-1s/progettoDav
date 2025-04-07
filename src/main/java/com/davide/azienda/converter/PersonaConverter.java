package com.davide.azienda.converter;


import com.davide.azienda.dto.PersonaDto;
import com.davide.azienda.model.Persona;

public class PersonaConverter {
	
	public PersonaDto convertToDto(Persona persona) {
		PersonaDto dto = new PersonaDto();
		dto.setCognome(persona.getCognome());
		dto.setNome(persona.getNome());
		dto.setId(persona.getid());
		dto.setAnniAnzianitaLavorativa(persona.getAnniAnzianitaLavorativa());
		dto.setRetribuzioneAnnua(persona.getRetribuzioneAnnua());
		return dto;
	}
	
	public Persona convertToEntity(PersonaDto dto) {
		Persona persona = new Persona();
		persona.setCognome(dto.getCognome());
		persona.setNome(dto.getNome());
		persona.setid(dto.getId());
		persona.setAnniAnzianitaLavorativa(dto.getAnniAnzianitaLavorativa());
		persona.setRetribuzioneAnnua(dto.getRetribuzioneAnnua());
		return persona;
	}

}
