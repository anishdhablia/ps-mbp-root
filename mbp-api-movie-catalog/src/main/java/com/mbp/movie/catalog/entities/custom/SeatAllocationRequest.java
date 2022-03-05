package com.mbp.movie.catalog.entities.custom;

import java.util.List;

public class SeatAllocationRequest {

	private int show;

	private List<SeatGroup> groups;

	public List<SeatGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<SeatGroup> groups) {
		this.groups = groups;
	}

	public int getShow() {
		return show;
	}

	public void setShowId(int show) {
		this.show = show;
	}

	public static class SeatGroup {

		private String label;
		private int seatCount;
		private String allocation;
		private String type;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public int getSeatCount() {
			return seatCount;
		}

		public void setSeatCount(int seatCount) {
			this.seatCount = seatCount;
		}

		public String getAllocation() {
			return allocation;
		}

		public void setAllocation(String allocation) {
			this.allocation = allocation;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		

	}

}
