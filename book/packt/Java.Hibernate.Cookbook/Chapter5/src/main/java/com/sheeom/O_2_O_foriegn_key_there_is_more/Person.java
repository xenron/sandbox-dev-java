package com.sheeom.O_2_O_foriegn_key_there_is_more;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passport_detail_id")
	private PassportDetail passportDetail;

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

	public PassportDetail getPassportDetail() {
		return passportDetail;
	}

	public void setPassportDetail(PassportDetail passportDetail) {
		this.passportDetail = passportDetail;
	}

	@Override
	public String toString() {
		return "Person"
				+"\n Id: " + this.id
				+"\n Name: " + this.name
				+"\n Passport Detail " 
				+ "\n\t Id: " + this.passportDetail.getId()
				+ "\n\t PassportNo: " + this.passportDetail.getPassportNo();
				
	} 

}
