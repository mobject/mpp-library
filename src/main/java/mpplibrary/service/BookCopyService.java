package mpplibrary.service;

import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import mpplibrary.model.User;
import mpplibrary.repository.BookCopyRepository;
import mpplibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

	/**
	 *
	 * @param book
	 * @param numberOfCopies
	 */
	public void addBookCopy(Book book, int numberOfCopies) {
        Iterable<BookCopy> bookCopies = buildBookCopies(book, numberOfCopies);
        bookCopyRepository.saveAll(bookCopies);
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
