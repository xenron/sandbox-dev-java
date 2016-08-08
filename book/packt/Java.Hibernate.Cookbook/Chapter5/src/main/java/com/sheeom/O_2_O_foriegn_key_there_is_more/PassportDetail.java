package com.sheeom.O_2_O_foriegn_key_there_is_more;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passport_detail")
public class PassportDetail {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "passportno")
	private String passportNo;

	@OneToOne(mappedBy = "passportDetail", cascade = CascadeType.ALL)
	private Person person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport Detail"
				+"\n Id: " + this.id
				+"\n Name: " + this.getPassportNo()
				+"\n Person " 
				+ "\n\t Id: " + this.person.getId()
				+ "\n\t PassportNo: " + this.person.getName();
				
	} 

}
