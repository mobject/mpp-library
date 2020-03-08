package mpplibrary.service;

import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookCopyDto;
import mpplibrary.dto.BookDto;
import mpplibrary.exception.AuthorNotFoundException;
import mpplibrary.exception.BookNotFoundException;
import mpplibrary.model.*;
import mpplibrary.repository.AuthorRepository;
import mpplibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookCopyService bookCopyService;

    public BookDto addBook(BookDto bookDto) {
        // TODO Unique isbn
        Book newBook = new Book();
        newBook.setIsbn(bookDto.getIsbn());
        newBook.setTitle(bookDto.getTitle());
        newBook.setMaxCheckoutDate(bookDto.getMaxCheckoutPeriodInDays());

        AuthorDto authorDto = bookDto.getAuthorDto();
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setPhone(authorDto.getPhone());
        author.setShortBio(authorDto.getShortBio());

        Address address = new Address();
        address.setStreet(authorDto.getStreet());
        address.setCity(authorDto.getCity());
        address.setState(authorDto.getState());
        address.setZip(authorDto.getZipCode());

        author.setAddress(address);
        newBook.setAuthor(author);

        BookCopy bookCopy = new BookCopy();
        bookCopy.setBook(newBook);
//        List<BookCopy> bookCopies = new ArrayList<>(Collections.singletonList(bookCopy));
//        newBook.setBookCopies(bookCopies);
        newBook = bookRepository.save(newBook);
        try {
			bookCopyService.addBookCopy(newBook.getIsbn(), 1);
		} catch (mpplibrary.exception.BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bookDto.setId(newBook.getId());
        authorDto.setId(newBook.getAuthor().getId());
        Author newAuthor = newBook.getAuthor();
        authorDto.setPhone(newAuthor.getPhone());
        bookDto.setAuthorDto(authorDto);

        return bookDto;
    }


    public BookDto updateBook(BookDto bookDto) {

        Book updateBook = bookRepository.findById(bookDto.getId()).orElseThrow(BookNotFoundException::new);
        // TODO Unique isbn

        updateBook.setIsbn(bookDto.getIsbn());
        updateBook.setTitle(bookDto.getTitle());
        updateBook.setMaxCheckoutDate(bookDto.getMaxCheckoutPeriodInDays());

        AuthorDto authorDto = bookDto.getAuthorDto();
		Author author = authorRepository.findById(updateBook.getAuthor().getId()).orElseThrow(AuthorNotFoundException::new);
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setPhone(authorDto.getPhone());
        author.setShortBio(authorDto.getShortBio());

        Address address = author.getAddress();
        address.setStreet(authorDto.getStreet());
        address.setCity(authorDto.getCity());
        address.setState(authorDto.getState());
        address.setZip(authorDto.getZipCode());

        author.setAddress(address);
        updateBook.setAuthor(author);
        updateBook = bookRepository.save(updateBook);

        bookDto.setId(updateBook.getId());
		authorDto.setId(updateBook.getAuthor().getId());
		bookDto.setAuthorDto(authorDto);
        return bookDto;
    }

    public List<BookCopyDto> getBookCopiesByIsbn(String isbn) {
        List<BookCopy> bookCopies = bookRepository.findByIsbn(isbn).orElseThrow(BookNotFoundException::new).getBookCopies();
        return bookCopies.stream().map(bookCopy -> {
            return new BookCopyDto(bookCopy.getId(), bookCopy.getBook().getTitle(), isbn, bookCopy.isAvailable());
        }).collect(Collectors.toList());
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findFirstByIsbn(isbn);
    }
}
