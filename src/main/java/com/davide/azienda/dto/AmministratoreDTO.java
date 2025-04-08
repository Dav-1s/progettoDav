package com.davide.azienda.dto;

public class AmministratoreDTO {
    private Long idPersona;

    public AmministratoreDTO() {
    }

    public AmministratoreDTO(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
}
