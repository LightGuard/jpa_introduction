package edu.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address", schema = "public")
public class Address implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "address_id_seq")
	private Long id;

	@Column(name = "line_1", nullable = false)
	private String line1;

	@Column(name = "line_2")
	private String line2;

	@Column(name = "line_3")
	private String line3;

	@Column(name = "city", nullable = false, length = 100)
	private String city;

	@Column(name = "postcode", nullable = false, length = 10)
	private String postcode;

	@Column(name = "province", nullable = false, length = 20)
	private String province;

	@Column(name = "country", nullable = false, length = 3)
	private String country;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
	private Library library;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private Set<Member> members = new HashSet<Member>(0);

	public long getId() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if (!city.equals(address.city)) return false;
		if (!country.equals(address.country)) return false;
		if (!id.equals(address.id)) return false;
		if (!line1.equals(address.line1)) return false;
		if (line2 != null ? !line2.equals(address.line2) : address.line2 != null) return false;
		if (line3 != null ? !line3.equals(address.line3) : address.line3 != null) return false;
		if (!postcode.equals(address.postcode)) return false;
		if (!province.equals(address.province)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + line1.hashCode();
		result = 31 * result + (line2 != null ? line2.hashCode() : 0);
		result = 31 * result + (line3 != null ? line3.hashCode() : 0);
		result = 31 * result + city.hashCode();
		result = 31 * result + postcode.hashCode();
		result = 31 * result + province.hashCode();
		result = 31 * result + country.hashCode();
		return result;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return this.line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Library getLibrary() {
		return this.library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Set<Member> getMembers() {
		return this.members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}
