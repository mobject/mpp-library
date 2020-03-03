package mpplibrary.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;
    private boolean available = true;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
