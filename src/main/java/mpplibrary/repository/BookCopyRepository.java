package mpplibrary.repository;

import mpplibrary.model.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    Optional<BookCopy> findFirstByAvailableAndBookIsbn(boolean isAvailable, String isbn);

    List<BookCopy> findAllByBookIsbn(String isbn);
}
