package com.sheeom.table_per_concreteclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@AttributeOverrides({
	@AttributeOverride(name="id", column = @Column(name="id")),
	@AttributeOverride(name="name", column = @Column(name="name"))
})

public class PermanentEmployee extends Employee {

	@Column(name = "salary")
	private Double salary;

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
