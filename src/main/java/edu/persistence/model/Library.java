package edu.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library", schema = "public")
public class Library implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "libary_name", nullable = false, length = 50)
	private String libaryName;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLibaryName() {
		return this.libaryName;
	}

	public void setLibaryName(String libaryName) {
		this.libaryName = libaryName;
	}

}
