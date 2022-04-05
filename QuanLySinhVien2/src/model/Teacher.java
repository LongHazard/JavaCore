package model;

import java.io.Serializable;

public class Teacher extends Person{
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	private String department;

}
