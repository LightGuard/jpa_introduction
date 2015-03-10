package edu.persistence.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
@NamedQuery(name = "bookByIsbn", query = "SELECT b from Book b WHERE b.isbn = :isbn")
public class Book implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "book_id_seq")
	private Long id;

	@Column(name = "isbn", unique = true, nullable = false, length = 13)
	private String isbn;

	@Column(name = "title", nullable = false)
	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publication_date", nullable = false, length = 29)
	private LocalDate publicationDate;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublicationDate() {
		return this.publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
}
