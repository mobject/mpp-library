package mpplibrary.repository;

import mpplibrary.model.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    public BookCopy findFirstByAvailableAndBookIsbn(boolean isAvailable, String isbn);
}
