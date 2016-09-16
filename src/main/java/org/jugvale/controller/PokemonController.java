package org.jugvale.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Collection;
import java.util.Objects;

import javax.validation.Valid;

import org.jugvale.controller.exceptions.ResourceNotFoundException;
import org.jugvale.model.entities.Pokemon;
import org.jugvale.model.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	//Busca todos sem HATEOAS
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Pokemon> buscaTodosSemHateoas(final Pageable pageable) {
		return pokemonRepository.findAll(pageable).getContent();
	}
	
	//Busca todos com HATEOAS
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = {"/hateoas", "/hateoas/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PagedResources<Resource<Pokemon>> buscaTodosComHateoas(final Pageable pageable, final PagedResourcesAssembler<Pokemon> assembler) {
		Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
		return assembler.toResource(pokemons);
	}
	
	//Busca um pokemon por nome
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public Resource<Pokemon> buscaPorNome(@PathVariable final String nome) {
		
		Pokemon pokemon = pokemonRepository.findByNomeIgnoreCase(nome).orElseThrow(ResourceNotFoundException :: new);
		Resource<Pokemon> resource = new Resource<Pokemon>(pokemon);
		
		resource.add(linkTo(methodOn(PokemonController.class).buscaPorNome(pokemon.getNome())).withSelfRel());
		
		if (Objects.nonNull(pokemon.getEvolucaoNome())) {
			resource.add(linkTo(methodOn(PokemonController.class).buscaPorNome(pokemon.getEvolucaoNome())).withRel("evolucao"));
		}
		
		return resource;
	}
	
	// cria um pokemon
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Pokemon cria(@Valid @RequestBody final Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}
	
	// Altera um pokemon
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@RequestMapping(method = RequestMethod.PUT)
	public Pokemon editar(@Valid @RequestBody final Pokemon pokemon) {
		
		if(Objects.isNull(pokemon.getId())) {
			throw new ResourceNotFoundException();
		}
		
		return pokemonRepository.save(pokemon);
	}
	
	//Deleta um pokemon
	@ResponseStatus(code = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable final Long id) {
		pokemonRepository.delete(id);
	}
	
}
