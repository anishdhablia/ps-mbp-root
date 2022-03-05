package com.mbp.movie.catalog.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the table_show_seat database table.
 * 
 */
@Entity
@Table(name="table_show_seat")
public class ShowSeat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String seat;
	
	@Column(name = "show_id")
	private int showId;

	public ShowSeat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeat() {
		return this.seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}	

}