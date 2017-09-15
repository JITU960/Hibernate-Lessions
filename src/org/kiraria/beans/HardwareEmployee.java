package org.kiraria.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HE")
public class HardwareEmployee extends Employee {

	public HardwareEmployee() {
		
	}
	private String Tool;
	public String getTool() {
		return Tool;
	}
	public void setTool(String tool) {
		Tool = tool;
	}
	
}
