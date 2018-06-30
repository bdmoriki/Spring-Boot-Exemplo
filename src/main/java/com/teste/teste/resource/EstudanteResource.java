package com.teste.teste.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teste.teste.model.Estudante;
import com.teste.teste.service.EstudanteService;

@RestController
@RequestMapping("api/v1/estudantes")
public class EstudanteResource {

	private final EstudanteService estudanteService;

	@Autowired
	public EstudanteResource(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estudante> obterTodosEstudantes() {
		return estudanteService.selecionarTodosEstudante();
	}

	@RequestMapping(
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{id}")
	public Estudante selecionarEstudantePorId(@PathVariable("id") UUID id) {
		return estudanteService.selecionarEstudantePorId(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

	public void inserirNovoEstudante(@RequestBody Estudante estudante) {
		estudanteService.inserirNovoEstudante(null, estudante);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{id}")
	public int atualizarEstudantePorId(@PathVariable("id") UUID id, @RequestBody Estudante estudante) {
		return estudanteService.atualizarEstudantePorId(id, estudante);
	}		
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{id}")
	public int removerEstudantePorId(@PathVariable("id") UUID id) {
		return estudanteService.removerEstudantePorId(id);
	}	

}
