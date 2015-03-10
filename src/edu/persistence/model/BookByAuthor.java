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
 * BookByAuthor generated by hbm2java
 */
@Entity
@Table(name = "book_by_author", schema = "public")
public class BookByAuthor implements java.io.Serializable {

	private BookByAuthorId id;
	private Book book;
	private Author author;

	public BookByAuthor() {
	}

	public BookByAuthor(BookByAuthorId id) {
		this.id = id;
	}

	public BookByAuthor(BookByAuthorId id, Book book, Author author) {
		this.id = id;
		this.book = book;
		this.author = author;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "authorId", column = @Column(name = "author_id")),
			@AttributeOverride(name = "bookId", column = @Column(name = "book_id")) })
	public BookByAuthorId getId() {
		return this.id;
	}

	public void setId(BookByAuthorId id) {
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
	@JoinColumn(name = "author_id", insertable = false, updatable = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}