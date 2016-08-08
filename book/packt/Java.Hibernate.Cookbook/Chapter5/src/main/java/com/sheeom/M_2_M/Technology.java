package com.sheeom.M_2_M;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "technology")
public class Technology {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "language")
	private String language;

	@Column(name = "expertise")
	private String expertise;

	@ManyToMany(mappedBy = "technology")
	private Set<Developer> developer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Set<Developer> getDeveloper() {
		return developer;
	}

	public void setDeveloper(Set<Developer> developer) {
		this.developer = developer;
	}
	
	@Override
	public String toString() {
		return "Technology"
				+"\n Id: " + this.id
				+"\n Language: " + this.language
				+"\n Expertise: " + this.expertise;
				
	}

}
