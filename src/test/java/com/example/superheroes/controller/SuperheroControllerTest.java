package com.example.superheroes.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.superheroes.model.Superhero;
import com.example.superheroes.service.SuperheroService;

public class SuperheroControllerTest {

	@Mock
	private SuperheroService superheroService;

	@InjectMocks
	private SuperheroController superheroController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(superheroController).build();
	}

	@Test
	public void testGetAllSuperheroes() throws Exception {
		List<Superhero> superheroes = new ArrayList<>();
		superheroes.add(new Superhero(1L, "Superman"));
		superheroes.add(new Superhero(2L, "Spiderman"));

		when(superheroService.getAllSuperheroes()).thenReturn(superheroes);

		mockMvc.perform(get("/superheroes")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$[0].name").value("Superman")).andExpect(jsonPath("$[1].name").value("Spiderman"));
	}

}
