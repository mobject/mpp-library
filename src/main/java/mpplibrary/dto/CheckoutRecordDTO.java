package mpplibrary.dto;

import mpplibrary.model.Author;
import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.model.Member;

public class CheckoutRecordDTO {

    private CheckoutRecord checkoutRecord;

    public CheckoutRecordDTO(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public Member getMember() {
        return checkoutRecord.getMember();
    }

    public Book getBook() {
        return checkoutRecord.getBookCopy().getBook();
    }

    public BookCopy getBookCopy() {
        return checkoutRecord.getBookCopy();
    }
    public String getMemberFirstName(){
        return this.getMember().getFirstName();
    }

    public String getMemberLastName() {
        return this.getMember().getLastName();
    }

    public String getBookTitle() {
        return this.getBook().getTitle();
    }

    public String getBookIsbn() {
        return this.getBook().getIsbn();
    }

    public String getDueDate() {
        return checkoutRecord.getDueDate().toString();
    }

    public String getCheckoutDate() {
        return checkoutRecord.getCheckoutDate().toString();
    }

    public int getId() {
        return checkoutRecord.getId();
    }
    
    public Author getAuthor() {
    	return checkoutRecord.getBookCopy().getBook().getAuthor();
    }
    
    public String getFirstName() {
    	return this.getAuthor().getFirstName();
    }
    
    public String getLastName() {
    	return this.getAuthor().getLastName();
    }
    
    public String getAuthorName() {
    	return this.getFirstName() + " " + this.getLastName();
    }

}
