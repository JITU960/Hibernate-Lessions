package org.kiraria.beans;

import org.kiraria.beans.Employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SE")
public class SoftwareEmployee extends Employee {
	private String Framework;

	public String getFramework() {
		return Framework;
	}

	public void setFramework(String framework) {
		Framework = framework;
	}
	
}
