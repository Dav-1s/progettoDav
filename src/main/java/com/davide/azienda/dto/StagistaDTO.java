package com.davide.azienda.dto;

public class StagistaDTO {
    private Long idPersona;
    private int oreDicembre;

    public StagistaDTO() {
    }

    public StagistaDTO(Long idPersona, int oreDicembre) {
        this.idPersona = idPersona;
        this.oreDicembre = oreDicembre;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public int getOreDicembre() {
        return oreDicembre;
    }

    public void setOreDicembre(int oreDicembre) {
        this.oreDicembre = oreDicembre;
    }
}
