package com.davide.azienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stagista")
public class Stagista {

    @Id
    private Long idPersona;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "ore_dicembre")
    private int oreDicembre;

    public Stagista() {
		// TODO Auto-generated constructor stub
	}
    

    public Stagista(Long idPersona, Persona persona, int oreDicembre) {
        this.idPersona = idPersona;
        this.persona = persona;
        this.oreDicembre = oreDicembre;
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

	public int getOreDicembre() {
		return oreDicembre;
	}

	public void setOreDicembre(int oreDicembre) {
		this.oreDicembre = oreDicembre;
	}
    
    
}