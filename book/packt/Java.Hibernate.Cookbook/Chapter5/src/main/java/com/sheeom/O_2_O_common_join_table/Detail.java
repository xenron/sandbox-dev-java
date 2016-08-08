package com.sheeom.O_2_O_common_join_table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail")
public class Detail {

	@Id
	@GeneratedValue
	@Column(name = "detail_id")
	private long id;

	@Column(name = "city")
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
			name="employee_detail"
			, joinColumns=@JoinColumn(name="detail_id")
			, inverseJoinColumns=@JoinColumn(name="employee_id")
	)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee Detail"
				+"\n Id: " + this.id
				+"\n City: " + this.city
				+"\n Employee " 
				+ "\n\t Id: " + this.employee.getId()
				+ "\n\t Name: " + this.employee.getName();
				
	} 
	
}
