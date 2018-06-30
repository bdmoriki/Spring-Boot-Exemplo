package com.teste.teste.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.teste.teste.dao.EstudanteDao;
import com.teste.teste.model.Estudante;

@Service
public class EstudanteService {

	private final EstudanteDao estudanteDao;
	
	@Autowired
	public EstudanteService(@Qualifier("fakeDao") EstudanteDao estudanteDao) {
		this.estudanteDao = estudanteDao;		
	}
	
    public int inserirNovoEstudante (UUID id, Estudante estudante) {
    	UUID idCriado = id == null ? UUID.randomUUID() : id;
    	estudante.setId(idCriado);
    	return estudanteDao.inserirNovoEstudante(idCriado, estudante);
    }

    public Estudante selecionarEstudantePorId(UUID id) {
    	return estudanteDao.selecionarEstudantePorId(id);
    }
    
    public List<Estudante> selecionarTodosEstudante(){
    	return estudanteDao.selecionarTodosEstudante();
    }
    
    public int atualizarEstudantePorId(UUID id, Estudante estudante) {
    	return estudanteDao.atualizarEstudantePorId(id, estudante);
    }

    public int removerEstudantePorId(UUID id) {
    	Estudante estudante = selecionarEstudantePorId(id);
    	
    	if (estudante ==  null) {
    		throw new IllegalStateException();
    	}
    	
    	return estudanteDao.removerEstudantePorId(id);    	
    }
    
}
