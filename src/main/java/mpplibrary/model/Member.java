package mpplibrary.model;

public class Member {
	private int idMember;
	private String firstName;
	private String lastName;
	private String phone;
	private Address address;
	
	public Member(String firstName, String lastName, String phone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public Member(int idMember, String firstName, String lastName, String phone, Address address) {
		this.idMember = idMember;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", address=" + address + "]";
	}
	
	
}
