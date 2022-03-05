package com.mbp.movie.catalog.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the table_show database table.
 * 
 */
@Entity
@Table(name="table_show")
public class Show implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@Column(name="movie_code")
	private String movieCode;

	@ManyToOne
	@JoinColumn(name="show2screen")
	private Screen screen;
	
	public Show() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getMovieCode() {
		return this.movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public Screen getScreen() {
		return this.screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

}