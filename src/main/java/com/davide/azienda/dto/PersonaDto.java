package com.davide.azienda.dto;

public class PersonaDto {

    private Integer id;
    private String nome;
    private String cognome;
    private int anniAnzianitaLavorativa;
    private int retribuzioneAnnua;

    public PersonaDto() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "id: " + this.id
    			+ "nome: " + this.nome
    			+ "cognome: " + this.cognome
    			+ "anni di anzianità lavorativa: " + this.anniAnzianitaLavorativa
    			+ "retribuzione annua: " + this.retribuzioneAnnua;
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

    public Integer getId() {  // Cambiato da getid() a getId()
        return id;
    }

    public void setId(Integer id) {  // Cambiato da setid() a setId()
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
