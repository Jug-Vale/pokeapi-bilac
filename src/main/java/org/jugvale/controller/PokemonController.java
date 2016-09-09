package org.jugvale.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.jugvale.model.entities.Pokemon;
import org.jugvale.model.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Pokemon> buscaTodos() {
		return pokemonRepository.findAll();
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public Pokemon buscaPorNome(@PathVariable final String nome) {
		return pokemonRepository.findByNomeIgnoreCase(nome);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pokemon cria(@Valid @RequestBody final Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Pokemon editar(@Valid @RequestBody final Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable final Long id) {
		pokemonRepository.delete(id);
	}
	
}
