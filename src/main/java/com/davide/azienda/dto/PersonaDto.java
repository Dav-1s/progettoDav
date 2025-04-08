package com.davide.azienda.dto;

import com.davide.azienda.model.TipoPersona;

public class PersonaDTO {
    private Long id;
    private String nome;
    private String cognome;
    private String matricola;
    private int anniAnzianita;
    private int stipendioAnnuo;
    private TipoPersona tipo;
    
    

    public PersonaDTO() {
    }

    public PersonaDTO(Long id, String nome, String cognome, String matricola, int anniAnzianita, int stipendioAnnuo, TipoPersona tipo) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
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

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

	public int getStipendioAnnuo() {
		return stipendioAnnuo;
	}

	public void setStipendioAnnuo(int stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}
}
    
    
