package mpplibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mpplibrary.model.CheckoutRecord;

@Repository
public interface CheckoutRecordRepository extends CrudRepository<CheckoutRecord, Long> {

	List<CheckoutRecord> findAllByMemberId(int id);

}
