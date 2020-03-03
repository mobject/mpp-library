package mpplibrary.repository;

import mpplibrary.model.Book;
import mpplibrary.model.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
