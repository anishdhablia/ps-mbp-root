package com.mbp.movie.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mbp.movie.catalog.entities.ShowSeat;

@RepositoryRestResource(exported = false)
public interface SeatRepository extends CrudRepository<ShowSeat, Integer>{

	List<ShowSeat> findByShowId(@Param(value = "showId") int showId);
	
	void deleteByShowId(@Param(value = "showId") int showId);
	
	boolean existsByShowId(int showId);
	
}
