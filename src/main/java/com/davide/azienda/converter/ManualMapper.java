package com.davide.azienda.converter;

import com.davide.azienda.dto.AmministratoreDTO;
import com.davide.azienda.dto.DirigenteDTO;
import com.davide.azienda.dto.DivisioneDTO;
import com.davide.azienda.dto.PersonaDTO;
import com.davide.azienda.dto.ProgettistaDTO;
import com.davide.azienda.dto.StagistaDTO;
import com.davide.azienda.model.Amministratore;
import com.davide.azienda.model.Dirigente;
import com.davide.azienda.model.Divisione;
import com.davide.azienda.model.Persona;
import com.davide.azienda.model.Progettista;
import com.davide.azienda.model.Stagista;

public class ManualMapper {
	


    public static DivisioneDTO divToDTO(Divisione divisione) {
        if (divisione == null) return null;
        return new DivisioneDTO(
            divisione.getId(),
            divisione.getNome(),
            divisione.getDirigente() != null ? divisione.getDirigente().getId() : null
        );
    }

    public static Divisione divToEntity(DivisioneDTO dto, Persona dirigente) {
        if (dto == null) return null;
        return new Divisione(
            dto.getId(),
            dto.getNome(),
            dirigente
        );
    }
    
    public static PersonaDTO perToDTO(Persona persona) {
        if (persona == null) return null;
        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setNome(persona.getNome());
        dto.setCognome(persona.getCognome());
        dto.setMatricola(persona.getMatricola());
        dto.setAnniAnzianita(persona.getAnniAnzianita());
        dto.setTipo(persona.getTipo());
        dto.setStipendioAnnuo(persona.getStipendioAnnuo());
        return dto;
    }


    public static Persona perToEntity(PersonaDTO dto) {
        if (dto == null) return null;
        Persona persona = new Persona();
        persona.setId(dto.getId());
        persona.setNome(dto.getNome());
        persona.setCognome(dto.getCognome());
        persona.setMatricola(dto.getMatricola());
        persona.setAnniAnzianita(dto.getAnniAnzianita());
        persona.setTipo(dto.getTipo());
        persona.setStipendioAnnuo(dto.getStipendioAnnuo());
        return persona;
    }

    public static ProgettistaDTO proToDTO(Progettista p) {
        if (p == null) return null;
        return new ProgettistaDTO(p.getIdPersona(), p.getDivisione() != null ? p.getDivisione().getId() : null);
    }

    public static Progettista proToEntity(ProgettistaDTO dto, Persona persona, Divisione divisione) {
        if (dto == null) return null;
        return new Progettista(dto.getIdPersona(), persona, divisione);
    }

    public static DirigenteDTO dirToDTO(Dirigente d) {
        if (d == null) return null;
        return new DirigenteDTO(d.getIdPersona(), d.getPremioDicembre());
    }

    public static Dirigente dirToEntity(DirigenteDTO dto, Persona persona) {
        if (dto == null) return null;
        return new Dirigente(dto.getIdPersona(), persona, dto.getPremioDicembre());
    }

    public static AmministratoreDTO ammToDTO(Amministratore a) {
        if (a == null) return null;
        return new AmministratoreDTO(a.getIdPersona());
    }

    public static Amministratore ammToEntity(AmministratoreDTO dto, Persona persona) {
        if (dto == null) return null;
        return new Amministratore(dto.getIdPersona(), persona);
    }

    public static StagistaDTO staToDTO(Stagista s) {
        if (s == null) return null;
        return new StagistaDTO(s.getIdPersona(), s.getOreDicembre());
    }

    public static Stagista staToEntity(StagistaDTO dto, Persona persona) {
        if (dto == null) return null;
        return new Stagista(dto.getIdPersona(), persona, dto.getOreDicembre());
    }

}
