package org.jugvale.model.entities;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Pokemon {
	
	private Long id;
	private String nome;
	private String categoria;
	private String habilidade;
	private BigDecimal altura;
	private BigDecimal peso;
	
	
	@ElementCollection
	@CollectionTable(name = "pokemon_tem_tipo")
	private Collection<String> tipo;
	

	@ElementCollection
	@CollectionTable(name = "pokemon_tem_fraqueza")
	private Collection<String> fraquezas;
	
	@ElementCollection
	@CollectionTable(name = "pokemon_tem_sexo")
	private Collection<Sexo> sexo;
	
	
}
