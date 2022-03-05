package com.mbp.movie.catalog.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbp.movie.catalog.entities.custom.SeatAllocation;
import com.mbp.movie.catalog.entities.custom.SeatAllocationRequest;
import com.mbp.movie.catalog.service.SeatService;

@RestController
public class Seats {

	@Autowired
	private SeatService seatService;  
	
	@PostMapping("/allocate")
	public void allocate(@RequestBody SeatAllocationRequest allocationRequest) {
		seatService.allocate(allocationRequest);
	}
	
	@GetMapping("/view/{show}")
	public SeatAllocation view(@PathVariable int show) {
		return seatService.lookup(show);
	}
	
}
