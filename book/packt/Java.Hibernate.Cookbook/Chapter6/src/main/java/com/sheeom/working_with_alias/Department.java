package com.sheeom.working_with_alias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sheeom.working_with_alias_there_is_more.Location;

@Entity
@Table
public class Department {
	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn
	private Location location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
