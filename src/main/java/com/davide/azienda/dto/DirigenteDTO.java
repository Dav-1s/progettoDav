package com.davide.azienda.dto;

import java.math.BigDecimal;


public class DirigenteDTO {
    private Long idPersona;
    private BigDecimal premioDicembre;
    private Long idDivisione;
    

    public DirigenteDTO() {
    }

    public DirigenteDTO(Long idPersona, BigDecimal premioDicembre, Long idDivisione) {
        this.idPersona = idPersona;
        this.premioDicembre = premioDicembre;
        this.idDivisione = idDivisione;
        
    }


	public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public BigDecimal getPremioDicembre() {
        return premioDicembre;
    }

    public void setPremioDicembre(BigDecimal premioDicembre) {
        this.premioDicembre = premioDicembre;
    }

	public Long getIdDivisione() {
		return idDivisione;
	}

	public void setIdDivisione(Long idDivisione) {
		this.idDivisione = idDivisione;
	}
}
