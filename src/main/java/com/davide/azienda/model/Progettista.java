package com.davide.azienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Progettista")
public class Progettista {

    @Id
    private Long idPersona;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_divisione")
    private Divisione divisione;

    public Progettista() {
		// TODO Auto-generated constructor stub
	}
    

    public Progettista(Long idPersona, Persona persona, Divisione divisione) {
        this.idPersona = idPersona;
        this.persona = persona;
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

	public Divisione getDivisione() {
		return divisione;
	}

	public void setDivisione(Divisione divisione) {
		this.divisione = divisione;
	}
    
}

