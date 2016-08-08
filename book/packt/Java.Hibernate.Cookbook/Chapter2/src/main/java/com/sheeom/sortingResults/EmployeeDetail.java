package com.sheeom.sortingResults;

	public class EmployeeDetail {
	    private long empId;
	    private String empFirstName;
	    private double empSalary;
	    private String empDeptName;

	    public long getEmpId() {
	   	 return empId;
	    }

	    public void setEmpId(long empId) {
	   	 this.empId = empId;
	    }

	    public String getEmpFirstName() {
	   	 return empFirstName;
	    }

	    public void setEmpFirstName(String empFirstName) {
	   	 this.empFirstName = empFirstName;
	    }

	    public double getEmpSalary() {
	   	 return empSalary;
	    }

	    public void setEmpSalary(double empSalary) {
	   	 this.empSalary = empSalary;
	    }

	    public String getEmpDeptName() {
	   	 return empDeptName;
	    }

	    public void setEmpDeptName(String empDeptName) {
	   	 this.empDeptName = empDeptName;
	    }
	    
	    @Override
	    public String toString() {
	   	 return "\nEmployeeDetail "
	   			 + "\n Employee id: " + this.empId
	   			 + "\n Employee FirstName: " + this.empFirstName
	   			 + "\n Employee Salary: " + this.empSalary
	   			 + "\n Employee DepartmentName : " + this.empDeptName;
	    }

	}
