package com.davide.azienda.dto;

public class StagistaDTO {
    private Long idPersona;
    private int oreStage;

    public StagistaDTO() {
    }

    public StagistaDTO(Long idPersona, int oreStage) {
        this.idPersona = idPersona;
        this.oreStage = oreStage;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public int getOreStage() {
        return oreStage;
    }

    public void setOreStage(int oreStage) {
        this.oreStage = oreStage;
    }
}
