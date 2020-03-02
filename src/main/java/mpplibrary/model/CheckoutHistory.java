package mpplibrary.model;

public class CheckoutHistory {
	private String isbn;
	private String bookName;
	private String authorName;
	private String checkoutDate;
	private String dueDate;
	
	public CheckoutHistory(String isbn, String bookName, String authorName, String checkoutDate, String dueDate) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.authorName = authorName;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	

}
