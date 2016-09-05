package org.jugvale.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getHabilidade() {
		return habilidade;
	}
	
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	
	public BigDecimal getAltura() {
		return altura;
	}
	
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	
	public BigDecimal getPeso() {
		return peso;
	}
	
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	
	public Collection<String> getTipo() {
		return tipo;
	}
	
	public void setTipo(Collection<String> tipo) {
		this.tipo = tipo;
	}
	
	public Collection<String> getFraquezas() {
		return fraquezas;
	}
	
	public void setFraquezas(Collection<String> fraquezas) {
		this.fraquezas = fraquezas;
	}
	
	public Collection<Sexo> getSexo() {
		return sexo;
	}
	
	public void setSexo(Collection<Sexo> sexo) {
		this.sexo = sexo;
	}
	
}
