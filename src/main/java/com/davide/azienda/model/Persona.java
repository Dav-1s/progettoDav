package com.davide.azienda.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoPersona", discriminatorType = DiscriminatorType.STRING)
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String cognome;
	private String nome;
	private int anniAnzianitaLavorativa;
	private int retribuzioneAnnua;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	public Persona(Integer id, String cognome, String nome, int anniAnzianitaLavorativa, int retribuzioneAnnua) {
	    this.id = id;
	    this.cognome = cognome;
	    this.nome = nome;
	    this.anniAnzianitaLavorativa = anniAnzianitaLavorativa;
	    this.retribuzioneAnnua = retribuzioneAnnua;
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

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public int getAnniAnzianitaLavorativa() {
		return anniAnzianitaLavorativa;
	}

	public void setAnniAnzianitaLavorativa(int anniAnzianitaLavorativa) {
		this.anniAnzianitaLavorativa = anniAnzianitaLavorativa;
	}

	public int getRetribuzioneAnnua() {
		return retribuzioneAnnua;
	}

	public void setRetribuzioneAnnua(int retribuzioneAnnua) {
		this.retribuzioneAnnua = retribuzioneAnnua;
	}
	
	

}
