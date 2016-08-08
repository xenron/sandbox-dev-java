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

public class ContractualEmployee extends Employee {

	@Column(name = "hourly_rate")
	private Double HourlyRate;

	@Column(name = "contract_period")
	private Float ContractPeriod;

	public Double getHourlyRate() {
		return HourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		HourlyRate = hourlyRate;
	}

	public Float getContractPeriod() {
		return ContractPeriod;
	}

	public void setContractPeriod(Float contractPeriod) {
		ContractPeriod = contractPeriod;
	}

}
