package com.example.superheroes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.superheroes.model.Superhero;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

	List<Superhero> findByNameContainingIgnoreCase(String keyword);

	Optional<Superhero> findByNameIgnoreCase(String name);

}
