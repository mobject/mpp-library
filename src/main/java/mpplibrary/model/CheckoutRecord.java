package mpplibrary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class CheckoutRecord implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private BookCopy bookCopy;

	@ManyToOne
	private Member member;

	@ManyToOne
	private User user;

	private LocalDate checkoutDate;
	private LocalDate dueDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
