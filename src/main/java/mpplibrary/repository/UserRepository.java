package mpplibrary.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mpplibrary.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
