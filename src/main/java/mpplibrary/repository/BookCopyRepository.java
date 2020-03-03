package mpplibrary.repository;

import mpplibrary.model.BookCopy;
import mpplibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

}
