package mpplibrary.repository;

import mpplibrary.model.CheckoutRecord;
import mpplibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRecordRepository extends CrudRepository<CheckoutRecord, Long> {

}
