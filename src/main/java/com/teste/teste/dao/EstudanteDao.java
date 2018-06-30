package com.teste.teste.dao;

import java.util.List;
import java.util.UUID;

import com.teste.teste.model.Estudante;

public interface EstudanteDao {

    int inserirNovoEstudante (UUID id, Estudante estudante);

    Estudante selecionarEstudantePorId(UUID id);
    
    List<Estudante> selecionarTodosEstudante();
    
    int atualizarEstudantePorId(UUID id, Estudante estudante);

    int removerEstudantePorId(UUID id);

}
