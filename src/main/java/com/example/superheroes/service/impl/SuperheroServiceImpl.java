package com.example.superheroes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.superheroes.model.Superhero;
import com.example.superheroes.repository.SuperheroRepository;
import com.example.superheroes.service.SuperheroService;

@Service
public class SuperheroServiceImpl implements SuperheroService {

	private SuperheroRepository superheroRepository;

	@Autowired
	SuperheroServiceImpl(SuperheroRepository superheroRepository) {
		this.superheroRepository = superheroRepository;
	}

	public List<Superhero> getAllSuperheroes() {
		return superheroRepository.findAll();
	}

	public Superhero getSuperheroById(Long id) {
		Optional<Superhero> superhero = superheroRepository.findById(id);

		if (superhero.isPresent()) {
			return superhero.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Superhero not found with id: " + id);
		}
	}

	public List<Superhero> findSuperheroesByName(String keyword) {
		return superheroRepository.findByNameContainingIgnoreCase(keyword);
	}

	public Superhero createSuperhero(Superhero superhero) {
		Optional<Superhero> superheroDb = superheroRepository.findByNameIgnoreCase(superhero.getName());

		if (superheroDb.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Superhero already exists");
		} else {
			return superheroRepository.save(superhero);
		}
	}

	public Superhero updateSuperhero(Long id, Superhero superhero) {
		if (!superheroRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Superhero not found with id: " + id);
		}

		superhero.setSuperheroId(id);

		return superheroRepository.save(superhero);
	}

	public void deleteSuperhero(Long id) {
		if (!superheroRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Superhero not found with id: " + id);
		}

		superheroRepository.deleteById(id);
	}

}
