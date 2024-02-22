package com.example.superheroes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.superheroes.model.Superhero;
import com.example.superheroes.repository.SuperheroRepository;
import com.example.superheroes.service.impl.SuperheroServiceImpl;

@SpringBootTest
class SuperheroesServiceTests {

	@Mock
	private SuperheroRepository superheroRepository;

	@InjectMocks
	private SuperheroServiceImpl superheroService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllSuperheroes() {
		List<Superhero> superheroes = new ArrayList<>();
		superheroes.add(new Superhero(1L, "Superman"));
		superheroes.add(new Superhero(2L, "Spiderman"));

		when(superheroRepository.findAll()).thenReturn(superheroes);

		List<Superhero> result = superheroService.getAllSuperheroes();

		assertEquals(2, result.size());
		assertEquals("Superman", result.get(0).getName());
		assertEquals("Spiderman", result.get(1).getName());

		verify(superheroRepository, times(1)).findAll();
	}

}
