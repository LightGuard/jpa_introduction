package edu.persistence.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_at_library", schema = "public")
public class BookAtLibrary implements java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity")),
			@AttributeOverride(name = "libraryId", column = @Column(name = "library_id")),
			@AttributeOverride(name = "bookId", column = @Column(name = "book_id")) })
	private BookAtLibraryId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_id", insertable = false, updatable = false)
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

	public BookAtLibraryId getId() {
		return this.id;
	}

	public void setId(BookAtLibraryId id) {
		this.id = id;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Library getLibrary() {
		return this.library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
