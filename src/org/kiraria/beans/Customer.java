/*
 * This entity uses the shipping address, one customer can have many shipping addresses,
 * shipping address is not an entity. But addresses are embedded in customer entity.
 */

package org.kiraria.beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="customer_id")
	private String customerId;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="customer_vehicle", joinColumns=@JoinColumn(name="customer_id"),
	inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	@NotFound(action=NotFoundAction.IGNORE)
	private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();
	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(Collection<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	@Access(value=AccessType.FIELD)
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="customer_addresses", joinColumns=@JoinColumn(name="customer_id"))
	private Collection<AddressShipping> addressShipping = new ArrayList<AddressShipping>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Collection<AddressShipping> getAddressShipping() {
		return addressShipping;
	}
	public void setAddressShipping(Collection<AddressShipping> addressShipping) {
		this.addressShipping = addressShipping;
	}
}
