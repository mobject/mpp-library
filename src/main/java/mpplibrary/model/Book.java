package mpplibrary.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAuthor")
	private Author author;
	private String isbn;
	private String title;
	private int maxCheckoutDate;

	@OneToMany//(mappedBy = "book", cascade = CascadeType.ALL)
	private List<BookCopy> bookCopies;

	public Book() {

	}

	public Book(int id, String isbn, String title, Author author) {
		this.title = title;
		this.id = id;
		this.isbn = isbn;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn + ", title: " + title;
	}

	public void setMaxCheckoutDate(int maxCheckoutDate) {
		this.maxCheckoutDate = maxCheckoutDate;
	}

	public int getMaxCheckoutDate() {
		return maxCheckoutDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}
}
