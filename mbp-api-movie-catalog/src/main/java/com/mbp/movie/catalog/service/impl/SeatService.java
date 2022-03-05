package com.mbp.movie.catalog.service.impl;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbp.movie.catalog.entities.ShowSeat;
import com.mbp.movie.catalog.entities.custom.SeatAllocation;
import com.mbp.movie.catalog.entities.custom.SeatAllocationRequest;
import com.mbp.movie.catalog.repository.SeatRepository;

@Service
public class SeatService implements com.mbp.movie.catalog.service.SeatService {

	@Autowired
	private SeatRepository repository;

	@Override
	public SeatAllocation lookup(int showId) {

		SeatAllocation allocation = null;
		try {
			ShowSeat showSeat = repository.findByShowId(showId).stream().findFirst().get();
			allocation = new ObjectMapper().readerFor(SeatAllocation.class).readValue(showSeat.getSeat());
		} catch (Exception e) {
			// Just of now
			e.printStackTrace();
		}

		return allocation;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, readOnly = false)
	@Override
	public void allocate(SeatAllocationRequest allocationRequest) {

		try {

			// Transformation
			SeatAllocation allocation = new SeatAllocation();
			allocation.setGroups(allocationRequest.getGroups().stream().map((group) -> this.transform(group))
					.collect(Collectors.toList()));

			ShowSeat seat = new ShowSeat();
			seat.setShowId(allocationRequest.getShow());
			seat.setSeat(new ObjectMapper().writer().writeValueAsString(allocation));

			repository.save(seat);

		} catch (Exception e) {
			// Just of now
			e.printStackTrace();
		}

	}

	private SeatAllocation.SeatGroup transform(SeatAllocationRequest.SeatGroup requestGroup) {

		/* Allocation Func to be implemented */

		SeatAllocation.SeatGroup seatGroup = new SeatAllocation.SeatGroup();
		seatGroup.setLabel(requestGroup.getLabel());
		seatGroup.setType(requestGroup.getType());
		seatGroup.setSeats(IntStream.range(1, requestGroup.getSeatCount())
				.mapToObj(i -> new SeatAllocation.Seat(i, true, false, null)).collect(Collectors.toList()));

		return seatGroup;
	}

}
