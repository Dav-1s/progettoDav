package com.davide.azienda.dto;

public class DivisioneDTO {
    private Long id;
    private String nome;
    private Long idDirigente; // Solo l'ID, non l'intera entità
    

    public DivisioneDTO() {
    }

    public DivisioneDTO(Long id, String nome, Long idDirigente) {
        this.id = id;
        this.nome = nome;
        this.idDirigente = idDirigente;
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

    public Long getIdDirigente() {
        return idDirigente;
    }

    public void setIdDirigente(Long idDirigente) {
        this.idDirigente = idDirigente;
    }
}
