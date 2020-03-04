package mpplibrary.service;

import mpplibrary.exception.BookNotFoundException;
import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.repository.BookCopyRepository;
import mpplibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookRepository bookRepository;

    public void addBookCopy(String isbn, int numberOfCopies) throws BookNotFoundException {
        Book book = bookRepository.findFirstByIsbn(isbn).orElseThrow(BookNotFoundException::new);
        Iterable<BookCopy> bookCopies = buildBookCopies(book, numberOfCopies);
        bookCopyRepository.saveAll(bookCopies);
    }

    public Optional<BookCopy> getAvailableBookCopy(String isbn) {
        return bookCopyRepository.findFirstByAvailableAndBookIsbn(true, isbn);
    }

    public List<BookCopy> findAllBookCopy(String isbn) {
        return bookCopyRepository.findAllByBookIsbn(isbn);
    }

    private Iterable<BookCopy> buildBookCopies(Book book, int numberOfCopies) {
        Set<BookCopy> bookCopySet = new HashSet<>();
        while (numberOfCopies > 0) {
            BookCopy bookCopy = new BookCopy();
            bookCopy.setBook(book);
            bookCopy.setAvailable(true);
            bookCopySet.add(bookCopy);
            numberOfCopies--;
        }
        return bookCopySet;
    }
}
