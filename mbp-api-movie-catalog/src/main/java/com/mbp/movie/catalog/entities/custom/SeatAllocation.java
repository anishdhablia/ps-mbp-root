package com.mbp.movie.catalog.entities.custom;

import java.util.Date;
import java.util.List;

public class SeatAllocation {

	private List<SeatGroup> groups;

	public List<SeatGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<SeatGroup> groups) {
		this.groups = groups;
	}
	
	public static class SeatGroup {

		private String type;
		private String label;
		List<Seat> seats;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public List<Seat> getSeats() {
			return seats;
		}

		public void setSeats(List<Seat> seats) {
			this.seats = seats;
		}

	}

	public static class Seat {

		private int number;
		private boolean available;
		private boolean blocked;
		private Date blockedOn;

		public Seat(int number, boolean available, boolean blocked, Date blockedOn) {
			super();
			this.number = number;
			this.available = available;
			this.blocked = blocked;
			this.blockedOn = blockedOn;
		}
		

		public Seat() {
			super();
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}

		public boolean isBlocked() {
			return blocked;
		}

		public void setBlocked(boolean blocked) {
			this.blocked = blocked;
		}

		public Date getBlockedOn() {
			return blockedOn;
		}

		public void setBlockedOn(Date blockedOn) {
			this.blockedOn = blockedOn;
		}

	}

}

