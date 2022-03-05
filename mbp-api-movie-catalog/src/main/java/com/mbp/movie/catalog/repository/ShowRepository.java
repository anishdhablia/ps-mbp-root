package com.mbp.movie.catalog.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.mbp.movie.catalog.entities.Show;

@RepositoryRestResource(collectionResourceRel = "shows", path = "show")
public interface ShowRepository extends org.springframework.data.repository.Repository<Show, Integer>{

	@RestResource(path = "find", rel = "search")
	List<Show> findByMovieCode(@Param(value = "code") String code);
	
	Iterable<Show> findAll();	
	
	Show findById(int id);
	
}
