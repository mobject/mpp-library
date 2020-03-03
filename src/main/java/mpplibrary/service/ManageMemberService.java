package mpplibrary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpplibrary.model.Address;
import mpplibrary.model.Member;
import mpplibrary.repository.ManageMemberRepository;

@Service
public class ManageMemberService {
	@Autowired
	private ManageMemberRepository manageRepository;

	public Member createMember(String firstName, String lastName, String phone, String street, String city, String state, String zip) {
		return manageRepository.save(saveMember(firstName, lastName, phone, street, city, state, zip));
	}
	
	public int getLatestMemberID() {
		return manageRepository.getLatestMemberID();
	}

	public Member updateMember(String memberId, String firstName, String lastName, String phone, String street, String city, String state,
			String zip) {
		Member member = manageRepository.findById(Integer.parseInt(memberId)).get();
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setPhone(phone);
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(Integer.parseInt(zip));
		member.setAddress(address);
		return manageRepository.save(member);
		
	}
	
	public Optional<Member> findById(int memberId) { 
		return manageRepository.findById(memberId);
	}
	
	public Member getMemberById(int memberId) {
		
		Member member = manageRepository.findById(memberId).orElse(null);
		return member;
		
	}
	
	private Member saveMember(String firstName, String lastName, String phone, String street, String city, String state,
			String zip) {
		Member member = new Member();
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setPhone(phone);
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(Integer.parseInt(zip));
		member.setAddress(address);
		return member;
	}

	public boolean isMemberExist(int memberId) {
		Optional<Member> member = findById(memberId);
		if (member.isPresent()){
		    return true;
		} else {
			return false;
		}
		
	}
	
}
