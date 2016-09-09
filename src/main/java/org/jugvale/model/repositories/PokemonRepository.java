package org.jugvale.model.repositories;

import java.util.Optional;

import org.jugvale.model.entities.Pokemon;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {
	Optional<Pokemon> findByNomeIgnoreCase(String nome);
}
