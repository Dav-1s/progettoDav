package com.davide.azienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Amministratore")
public class Amministratore {

    @Id
    private Long idPersona;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Amministratore() {
    }

    public Amministratore(Long idPersona, Persona persona) {
        this.idPersona = idPersona;
        this.persona = persona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
