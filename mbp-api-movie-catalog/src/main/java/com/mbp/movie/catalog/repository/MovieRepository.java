package com.mbp.movie.catalog.repository;

import java.util.Optional;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mbp.movie.catalog.entities.Movie;
import com.mbp.movie.catalog.entities.Show;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends org.springframework.data.repository.Repository<Movie, Integer>{

	Optional<Show> findById(Integer id);
	
	Iterable<Show> findAll();

	Iterable<Show> findAllById(Iterable<Integer> ids);
	
}
