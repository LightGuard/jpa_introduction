package edu.persistence.model;

// Generated Mar 10, 2015 10:56:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BookAtLibrary generated by hbm2java
 */
@Entity
@Table(name = "book_at_library", schema = "public")
public class BookAtLibrary implements java.io.Serializable {

	private BookAtLibraryId id;
	private Book book;
	private Library library;

	public BookAtLibrary() {
	}

	public BookAtLibrary(BookAtLibraryId id) {
		this.id = id;
	}

	public BookAtLibrary(BookAtLibraryId id, Book book, Library library) {
		this.id = id;
		this.book = book;
		this.library = library;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity", precision = 8, scale = 8)),
			@AttributeOverride(name = "libraryId", column = @Column(name = "library_id")),
			@AttributeOverride(name = "bookId", column = @Column(name = "book_id")) })
	public BookAtLibraryId getId() {
		return this.id;
	}

	public void setId(BookAtLibraryId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_id", insertable = false, updatable = false)
	public Library getLibrary() {
		return this.library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
