package edu.persistence.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "author", schema = "public")
public class Author implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(initialValue = 1, name = "author_id_seq")
	private Long id;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 30)
	private String lastName;

    @Transient
	private Set<Book> booksAuthored = new HashSet<Book>(0);

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Author author = (Author) o;

		if (!firstName.equals(author.firstName)) return false;
		if (id != null ? !id.equals(author.id) : author.id != null) return false;
		if (!lastName.equals(author.lastName)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}
}
