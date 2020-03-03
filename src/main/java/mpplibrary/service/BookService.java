package mpplibrary.service;

import mpplibrary.model.Book;
import mpplibrary.model.User;
import mpplibrary.repository.BookRepository;
import mpplibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book addBook(String isbn, String title, int maxCheckoutDate) {
		Book newBook = new Book();
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setMaxCheckoutDate(maxCheckoutDate);
		return bookRepository.save(newBook);
	}
}
