package com.davide.azienda.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dirigente")
public class Dirigente {

    @Id
    private Long idPersona;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "premio_dicembre")
    private BigDecimal premioDicembre;

    public Dirigente() {
		// TODO Auto-generated constructor stub
	}
    

    public Dirigente(Long idPersona, Persona persona, BigDecimal premioDicembre) {
        this.idPersona = idPersona;
        this.persona = persona;
        this.premioDicembre = premioDicembre;
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

	public BigDecimal getPremioDicembre() {
		return premioDicembre;
	}

	public void setPremioDicembre(BigDecimal premioDicembre) {
		this.premioDicembre = premioDicembre;
	}
}
