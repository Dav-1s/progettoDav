package com.davide.azienda.dto;

import java.math.BigDecimal;

public class DirigenteDTO {
    private Long idPersona;
    private BigDecimal premioDicembre;
    

    public DirigenteDTO() {
    }

    public DirigenteDTO(Long idPersona, BigDecimal premioDicembre) {
        this.idPersona = idPersona;
        this.premioDicembre = premioDicembre;
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
}
