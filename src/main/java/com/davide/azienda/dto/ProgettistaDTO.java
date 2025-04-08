package com.davide.azienda.dto;

public class ProgettistaDTO {
    private Long idPersona;
    private Long idDivisione;
    

    public ProgettistaDTO() {
    }

    public ProgettistaDTO(Long idPersona, Long idDivisione) {
        this.idPersona = idPersona;
        this.idDivisione = idDivisione;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdDivisione() {
        return idDivisione;
    }

    public void setIdDivisione(Long idDivisione) {
        this.idDivisione = idDivisione;
    }
}