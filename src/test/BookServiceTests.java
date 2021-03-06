import mpplibrary.LibraryApplication;
import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookCopyDto;
import mpplibrary.dto.BookDto;
import mpplibrary.model.Book;
import mpplibrary.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = LibraryApplication.class)
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Test
    public void context() {

    }

    @Test
    public void shouldAddNewBook() {
        BookDto bookDto = new BookDto("isbn-13e", "The Big Bang", 17);
        AuthorDto authorDto = new AuthorDto("Guyin", "Moze", "07041928388", "This buy had to guy a bic gar", "1000 N.", "Fairfield", "Iowa", 52557);
        bookDto.setAuthorDto(authorDto);
        bookDto = bookService.addBook( bookDto);
        Assert.assertNotNull("New book id is null", bookDto.getId());
        Assert.assertNotNull("New book author phone number is null", bookDto.getAuthorDto().getPhone());
        Assert.assertTrue("New book id can not be <= 0", bookDto.getId() > 0);
    }

    @Test
    public void shouldUpdateBook() {
        BookDto bookDto = new BookDto("isbn-13e", "The Big Bang", 17);
        AuthorDto authorDto = new AuthorDto("Guyin", "Moze", "07041928388", "This buy had to guy a bic gar", "1000 N.", "Fairfield", "Iowa", 52557);
        bookDto.setAuthorDto(authorDto);
        bookDto = bookService.addBook( bookDto);
        Assert.assertNotNull("New book id is null", bookDto.getId());
        Assert.assertTrue("New book id can not be <= 0", bookDto.getId() > 0);

        String updateTitle = "Title Update";
        String authorFirstName = "First Name Update";
        String authorCity = "City update";

        bookDto.setTitle(updateTitle);
        authorDto.setFirstName(authorFirstName);
        authorDto.setCity(authorCity);
        bookDto.setAuthorDto(authorDto);
        bookDto = bookService.updateBook(bookDto);

        Assert.assertEquals(updateTitle, bookDto.getTitle());
        Assert.assertEquals(authorFirstName, bookDto.getAuthorDto().getFirstName());
        Assert.assertEquals(authorCity, bookDto.getAuthorDto().getCity());


    }


    @Transactional
    @Test
    public void shouldGetNoOfCopiesAvailable() {
        String isbn = "isbn-13e";
        BookDto bookDto = new BookDto(isbn, "The Big Bang", 17);
        AuthorDto authorDto = new AuthorDto("Guyin", "Moze", "07041928388", "This buy had to guy a bic gar", "1000 N.", "Fairfield", "Iowa", 52557);
        bookDto.setAuthorDto(authorDto);
        bookDto = bookService.addBook( bookDto);
        Assert.assertNotNull("New book id is null", bookDto.getId());
        Assert.assertTrue("New book id can not be <= 0", bookDto.getId() > 0);
        List<BookCopyDto> bookCopies = bookService.getBookCopiesByIsbn(isbn);
        Assert.assertTrue("No book copy found",bookCopies.size() > 0 );
        System.out.println("Book copies: ");
        bookCopies.forEach(System.out::println);
    }
}
