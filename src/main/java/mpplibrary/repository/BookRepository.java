package mpplibrary.repository;

import mpplibrary.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);
}
