package com.example.superheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroes.model.Superhero;
import com.example.superheroes.service.SuperheroService;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {

	private SuperheroService superheroService;

	@Autowired
	SuperheroController(SuperheroService superheroService) {
		this.superheroService = superheroService;
	}

	@GetMapping
	public List<Superhero> getAllSuperheroes() {
		return superheroService.getAllSuperheroes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getSuperheroById(@PathVariable Long id) {
		return new ResponseEntity<>(superheroService.getSuperheroById(id), HttpStatus.OK);
	}

	@GetMapping("/search")
	public List<Superhero> searchSuperheroesByName(@RequestParam("keyword") String keyword) {
		return superheroService.findSuperheroesByName(keyword);
	}

	@PostMapping
	public Superhero createSuperhero(@RequestBody Superhero superhero) {
		return superheroService.createSuperhero(superhero);
	}

	@PutMapping("/{id}")
	public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superhero) {
		return superheroService.updateSuperhero(id, superhero);
	}

	@DeleteMapping("/{id}")
	public void deleteSuperhero(@PathVariable Long id) {
		superheroService.deleteSuperhero(id);
	}

}
