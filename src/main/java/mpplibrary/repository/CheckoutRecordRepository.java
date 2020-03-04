package mpplibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mpplibrary.model.CheckoutRecord;

@Repository
public interface CheckoutRecordRepository extends CrudRepository<CheckoutRecord, Integer> {

	List<CheckoutRecord> findAllByMemberId(int id);

	@Query(value = "SELECT COUNT(1) FROM CheckoutRecord WHERE idMember=:idMember")
	int existByIdMember(@Param("idMember") int memberId);

}
