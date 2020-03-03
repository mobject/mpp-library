package mpplibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	private String isbn;
	private String title;
	private int maxCheckoutDate;

	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn;
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

	public int getMaxCheckoutDate() {
		return maxCheckoutDate;
	}

	public void setMaxCheckoutDate(int maxCheckoutDate) {
		this.maxCheckoutDate = maxCheckoutDate;
	}
}
