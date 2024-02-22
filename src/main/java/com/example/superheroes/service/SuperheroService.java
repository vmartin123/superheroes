package com.example.superheroes.service;

import java.util.List;

import com.example.superheroes.model.Superhero;

public interface SuperheroService {

	List<Superhero> getAllSuperheroes();

	Superhero getSuperheroById(Long id);

	List<Superhero> findSuperheroesByName(String keyword);

	Superhero createSuperhero(Superhero superhero);

	Superhero updateSuperhero(Long id, Superhero superhero);

	void deleteSuperhero(Long id);

}
