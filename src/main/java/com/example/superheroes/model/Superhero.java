package com.example.superheroes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Superhero {

	public Superhero() {
		super();
	}

	public Superhero(Long superheroId, String name) {
		super();
		this.superheroId = superheroId;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "superhero_id")
	private Long superheroId;

	@Column(unique = true)
	private String name;

	public Long getSuperheroId() {
		return superheroId;
	}

	public void setSuperheroId(Long superheroId) {
		this.superheroId = superheroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
