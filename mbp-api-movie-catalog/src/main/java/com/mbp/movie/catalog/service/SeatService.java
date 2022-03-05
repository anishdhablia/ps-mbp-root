package com.mbp.movie.catalog.service;

import com.mbp.movie.catalog.entities.custom.SeatAllocation;
import com.mbp.movie.catalog.entities.custom.SeatAllocationRequest;

public interface SeatService {

	SeatAllocation lookup(int showId);

	void allocate(SeatAllocationRequest allocationRequest);

}