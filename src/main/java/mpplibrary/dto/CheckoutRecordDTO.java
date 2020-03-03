package mpplibrary.dto;

import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.model.Member;

public class CheckoutRecordDTO {
    private Member member;
    private Book book;
    private BookCopy bookCopy;

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getMemberFirstName(){
        return member.getFirstName();
    }
    public String getMemberLastName(){
        return member.getLastName();
    }

    public String getBookTitle(){
        return book.getTitle();
    }

    public String getBookIsbn(){
        return book.getIsbn();
    }

//    public String getDueDate(){
//        return bookCopy.getDueDate().toString();
//    }
//
//    public String getCheckoutDate() {
//        return getBookCopy().getCheckoutDate().toString();
//    }
}
