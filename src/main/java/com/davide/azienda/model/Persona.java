package com.davide.azienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cognome;
    private String nome;

    @Column(unique = true)
    private String matricola;

    @Column(name = "anni_anzianita")
    private int anniAnzianita;
    
    @Column(name = "stipendio_annuo")
    private int stipendioAnnuo;

    @Enumerated(EnumType.STRING)
    private TipoPersona tipo;

    public Persona() {
		// TODO Auto-generated constructor stub
	}
    
    public Persona(Long id, String nome, String cognome, String matricola, int anniAnzianita, int stipendioAnnuo, TipoPersona tipo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.anniAnzianita = anniAnzianita;
        this.stipendioAnnuo = stipendioAnnuo;
        this.tipo = tipo;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getAnniAnzianita() {
		return anniAnzianita;
	}

	public void setAnniAnzianita(int anniAnzianita) {
		this.anniAnzianita = anniAnzianita;
	}

	public int getStipendioAnnuo() {
		return stipendioAnnuo;
	}

	public void setStipendioAnnuo(int stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}

	public TipoPersona getTipo() {
		return tipo;
	}

	public void setTipo(TipoPersona tipo) {
		this.tipo = tipo;
	}
    
    
}
