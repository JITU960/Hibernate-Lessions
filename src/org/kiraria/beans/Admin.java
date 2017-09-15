package org.kiraria.beans;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Employee {
	private int experience;
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Admin() {
		
	}

}
