package com.davide.azienda.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @ManyToOne
    @JoinColumn(name = "id_divisione")
    private Divisione divisione;

    public Dirigente() {
		// TODO Auto-generated constructor stub
	}
    

    public Dirigente(Long idPersona, Persona persona, BigDecimal premioDicembre, Divisione divisione) {
        this.idPersona = idPersona;
        this.persona = persona;
        this.premioDicembre = premioDicembre;
        this.divisione = divisione;
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

	public Divisione getDivisione() {
		return divisione;
	}

	public void setDivisione(Divisione divisione) {
		this.divisione = divisione;
	}
}
