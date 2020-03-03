package mpplibrary.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mpplibrary.model.Member;
import mpplibrary.service.ManageMemberService;

@Component
public class ManageMemberController {

    @Autowired
    private ManageMemberService manageMemberService;
    
    public void addMember(String firstName, String lastName, String phone, String street, String city, String state, String zip) {
    	manageMemberService.createMember(firstName, lastName, phone, street, city, state, zip);
    }
    
    public void updateMember(String memberId, String firstName, String lastName, String phone, String street, String city, String state, String zip) {
    	manageMemberService.updateMember(memberId, firstName, lastName, phone, street, city, state, zip);
    }
    
    public int getLatestMemberId() {
    	return manageMemberService.getLatestMemberID();
    }
    
    public Optional<Member> findById(int memberId) { 
		return manageMemberService.findById(memberId);
	}

	public boolean isMemberExist(int memberId) {
		return manageMemberService.isMemberExist(memberId);
	}
	
	public Member getMemberById(int memberId) {
		return manageMemberService.getMemberById(memberId);
	}
    
}
