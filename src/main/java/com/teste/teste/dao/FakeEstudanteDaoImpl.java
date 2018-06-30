package com.teste.teste.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.teste.teste.model.Estudante;

@Repository("fakeDao")
public class FakeEstudanteDaoImpl implements EstudanteDao {

	private final Map<UUID, Estudante> tabela;
	
	public FakeEstudanteDaoImpl() {
		this.tabela = new HashMap<>();
		UUID chave = UUID.randomUUID();
		this.tabela.put(chave, new Estudante(chave, 20, "Bruno", "Silva", "Analise de Sistemas"));
	}
	
	@Override
	public int inserirNovoEstudante(UUID id, Estudante estudante) {
		this.tabela.put(id, estudante);
		return 1;
	}

	@Override
	public Estudante selecionarEstudantePorId(UUID id) {
		return tabela.get(id);
	}

	@Override
	public List<Estudante> selecionarTodosEstudante() {
		return new ArrayList<>(tabela.values());
	}

	@Override
	public int atualizarEstudantePorId(UUID id, Estudante estudante) {
		this.tabela.put(id, estudante);
		return 1;
	}

	@Override
	public int removerEstudantePorId(UUID id) {
		this.tabela.remove(id);
		return 1;
	}
	
}