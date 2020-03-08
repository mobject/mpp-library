package mpplibrary.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mpplibrary.model.Member;

@Repository
public interface ManageMemberRepository extends CrudRepository<Member, Integer> {

	//Get latest Member ID query
	@Query(value = "SELECT COUNT(*) FROM Member")
	public int getLatestMemberID();
	
	
}
