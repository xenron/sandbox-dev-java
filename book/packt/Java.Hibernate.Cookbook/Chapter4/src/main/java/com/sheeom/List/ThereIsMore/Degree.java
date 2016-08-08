package com.sheeom.List.ThereIsMore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="degree")
public class Degree {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="degreename")
	private String degreeName;
	
	@Column(name="passingyear")
	private int passingYear;

	public Degree() {
	
	}
	
	public Degree(String degreeName, int passingYear) {
		this.degreeName = degreeName;
		this.passingYear = passingYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public int getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(int passingYear) {
		this.passingYear = passingYear;
	}

	@Override
	public String toString() {
		return "\n\nDegree " 
				+ "\n\tId:" + this.id
				+ "\n\tName:" + this.degreeName
				+ "\n\tPassing year:" + this.passingYear;
	}
}
