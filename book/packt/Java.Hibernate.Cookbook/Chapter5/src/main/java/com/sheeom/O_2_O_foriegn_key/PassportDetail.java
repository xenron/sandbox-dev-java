package com.sheeom.O_2_O_foriegn_key;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

}
