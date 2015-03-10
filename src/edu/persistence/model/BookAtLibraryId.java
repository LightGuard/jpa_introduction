package edu.persistence.model;

// Generated Mar 10, 2015 10:56:57 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BookAtLibraryId generated by hbm2java
 */
@Embeddable
public class BookAtLibraryId implements java.io.Serializable {

	private Float quantity;
	private Long libraryId;
	private Long bookId;

	public BookAtLibraryId() {
	}

	public BookAtLibraryId(Float quantity, Long libraryId, Long bookId) {
		this.quantity = quantity;
		this.libraryId = libraryId;
		this.bookId = bookId;
	}

	@Column(name = "quantity", precision = 8, scale = 8)
	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	@Column(name = "library_id")
	public Long getLibraryId() {
		return this.libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}

	@Column(name = "book_id")
	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookAtLibraryId))
			return false;
		BookAtLibraryId castOther = (BookAtLibraryId) other;

		return ((this.getQuantity() == castOther.getQuantity()) || (this
				.getQuantity() != null && castOther.getQuantity() != null && this
				.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getLibraryId() == castOther.getLibraryId()) || (this
						.getLibraryId() != null
						&& castOther.getLibraryId() != null && this
						.getLibraryId().equals(castOther.getLibraryId())))
				&& ((this.getBookId() == castOther.getBookId()) || (this
						.getBookId() != null && castOther.getBookId() != null && this
						.getBookId().equals(castOther.getBookId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37 * result
				+ (getLibraryId() == null ? 0 : this.getLibraryId().hashCode());
		result = 37 * result
				+ (getBookId() == null ? 0 : this.getBookId().hashCode());
		return result;
	}

}