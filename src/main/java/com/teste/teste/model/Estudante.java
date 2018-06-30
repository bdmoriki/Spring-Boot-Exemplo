package com.teste.teste.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estudante {

    private UUID id;

    private final Integer idade;

    private final String nome;

    private final String sobrenome;

    private final String curso;

    public Estudante(
            @JsonProperty("id") UUID id,
            @JsonProperty("idade") Integer idade,
            @JsonProperty("nome") String nome,
            @JsonProperty("sobrenome") String sobrenome,
            @JsonProperty("curso") String curso) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCurso() {
		return curso;
	}
	
}