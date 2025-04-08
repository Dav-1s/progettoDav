package com.davide.azienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Divisione")
public class Divisione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "id_dirigente", unique = true)
    private Persona dirigente;

    public Divisione() {
		// TODO Auto-generated constructor stub
	}
    

    public Divisione(Long id, String nome, Persona dirigente) {
        this.id = id;
        this.nome = nome;
        this.dirigente = dirigente;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Persona getDirigente() {
		return dirigente;
	}

	public void setDirigente(Persona dirigente) {
		this.dirigente = dirigente;
	}
    
}

