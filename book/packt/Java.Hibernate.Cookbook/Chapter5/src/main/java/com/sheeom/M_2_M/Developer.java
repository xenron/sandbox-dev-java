package com.sheeom.M_2_M;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "developer")
public class Developer {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Technology> technology;

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

	public Set<Technology> getTechnology() {
		return technology;
	}

	public void setTechnology(Set<Technology> technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "Developer" + "\n Id: " + this.id 
				+ "\n Name: " + 		this.name;

	}
}
