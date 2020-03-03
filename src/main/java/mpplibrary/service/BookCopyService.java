package mpplibrary.service;

import mpplibrary.model.User;
import mpplibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCopyService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(String firstName, String lastName, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		return userRepository.save(user);
	}
}
