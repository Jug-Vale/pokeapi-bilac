package org.jugvale.model.repositories;

import org.jugvale.model.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	
	Pokemon findByNomeIgnoreCase(String nome);
	
}
